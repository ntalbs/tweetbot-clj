(ns tweetbot.conf)

(def conf
  {:oauth-settings {:consumer-key (System/getenv "TWEETBOT_TWITTER_CONSUMER_KEY"),
                    :consumer-secret (System/getenv "TWEETBOT_TWITTER_CONSUMER_SECRET"),
                    :access-token (System/getenv "TWEETBOT_TWITTER_ACCESS_TOKEN"),
                    :access-token-secret (System/getenv "TWEETBOT_TWITTER_ACCESS_TOKEN_SECRET")}
   :db-uri "db-url"
   :tweet-interval (* 1000 60 60)})
