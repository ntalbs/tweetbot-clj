(ns tweetbot.backup
  (:require [monger.core :as mg]
            [monger.collection :as mc])
  (:use [clojure.java.io]
        [tweetbot.config]))

(def db-uri (config :db-uri))

(defn -main [& args]
  (let [filename (first args)]
    (do
      (mg/connect-via-uri! db-uri)
      (with-open [w (writer (str "./" filename "backup.clj"))]
        (.write w (.toString (mc/find-maps "quotes")))))))
