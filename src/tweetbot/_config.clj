(ns tweetbot.conf)

(def conf
  {:oauth-settings {:consumer-key "consumer-key"
                    :consumer-secret "consumer-secret"
                    :access-token "access-token"
                    :access-token-secret "access-token-secret"}
   :db-uri "db-url"
   :tweet-interval (* 1000 60 60)})
