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

(defn tweet [msg]
  (statuses-update :oauth-creds tweetbot-creds
                   :params {:status msg}))

(defn random-msg []
  (let [msg (rand-nth messages)]
    (str (msg :msg) "\n" (msg :src))))

(defn -main [& args]
  ;; (every 1000 #(println (random-msg)) thread-pool))
  (->> (map #(:text %) (:body (statuses-user-timeline :oauth-creds tweetbot-creds
                                                      :params {:screen-name "ntalbs" :count 500})))

       (filter #(re-find #"셈코 스토리" %))
       (clojure.string/join "\n")
       (println)))
    
