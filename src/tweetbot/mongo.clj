;; load messages in quotes.clj into mongodb

(ns tweetbot.data
  (:use [monger.core :only [connect-via-uri! disconnect!]]
        [monger.collection :only [insert-batch]]))

(def db-uri (:db-uri (load-file "src/tweetbot/db-conf.clj")))

(def messages (load-file "src/tweetbot/quotes.clj"))

(do
  (connect-via-uri! db-uri)
  (insert-batch "quotes" messages)
  (disconnect!))
