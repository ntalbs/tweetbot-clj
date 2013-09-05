(ns tweetbot.main
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [monger.query :as mq])
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful]
        [overtone.at-at]
        [tweetbot.conf]))

(def thread-pool (mk-pool))
(def db-uri (conf :db-uri))
(def tweet-interval (conf :tweet-interval))

(def tweetbot-creds
  (let [creds (conf :oauth-settings)]
    (make-oauth-creds (creds :consumer-key)
                      (creds :consumer-secret)
                      (creds :access-token)
                      (creds :access-token-secret))))

;; (defn get-tweets [screen-name keyword]
;;   (->> (statuses-user-timeline :oauth-creds tweetbot-creds
;;                                :params {:screen-name screen-name :count 500})
;;        (:body)
;;        (map #(:text %))
;;        (filter #(re-find (re-pattern keyword) %))))

(defn tweet [msg]
  (do
    (statuses-update :oauth-creds tweetbot-creds :params {:status msg})
    (println ">>> " (new java.util.Date))
    (println msg "\n")))

(defn random-msg []
  (let [cnt (mc/count "quotes")
        rnd (rand-int cnt)
        msg (first (mq/with-collection "quotes"
                     (mq/skip rnd)
                     (mq/limit 1)
                     (mq/snapshot)))]
    (str (msg :msg) "\n" (msg :src))))

(defn -main [& args]
  (do
    (mg/connect-via-uri! db-uri)
    (every tweet-interval #(tweet (random-msg)) thread-pool)))
