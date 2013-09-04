(ns tweetbot.main
  (:use [twitter.oauth]
        [twitter.callbacks]
        [twitter.callbacks.handlers]
        [twitter.api.restful]
        [overtone.at-at]))

(def one-hour (* 1000 60 60))

(def thread-pool (mk-pool))

(def tweetbot-creds
  (let [creds (load-file "src/tweetbot/creds.clj")]
    (make-oauth-creds (creds :consumer-key)
                      (creds :consumer-setcret)
                      (creds :access-token)
                      (creds :access-token-secret))))

(def messages (load-file "src/tweetbot/quotes.clj"))

;; (defn get-tweets [screen-name keyword]
;;   (->> (statuses-user-timeline :oauth-creds tweetbot-creds
;;                                :params {:screen-name screen-name :count 500})
;;        (:body)
;;        (map #(:text %))
;;        (filter #(re-find (re-pattern keyword) %))))

(defn tweet [msg]
  (statuses-update :oauth-creds tweetbot-creds :params {:status msg}))

(defn random-msg []
  (let [msg (rand-nth messages)]
    (str (msg :msg) "\n" (msg :src))))

(defn -main [& args]
  (every 1000 #(tweet (random-msg)) thread-pool))
