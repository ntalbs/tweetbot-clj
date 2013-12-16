(defproject tweetbot "0.1.0"
  :description "Tweet Bot"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [twitter-api "0.7.4"]
                 [overtone/at-at "1.2.0"]
                 [com.novemberain/monger "1.5.0"]]
  :main tweetbot.main)
