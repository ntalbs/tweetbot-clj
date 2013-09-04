Tweetbot
========

Simple tweet bot written in Clojure.

## Setup
Clone this project, copy `_db-config.clj` to `db-conf.clj` 
and `_oauth-settings.clj` to `oauth-settings.clj`.

    $ git clone https://github.com/ntalbs/tweetbot.git
    $ cd tweetbot/src/tweetbot
    $ cp _db-config.clj db-config.clj
    $ cp _oauth-settings.clj oauth-settings.clj

After the above steps, edit `db-conf.clj` and `oauth-settings.clj`.

## Loading initial data
You can load initial data in `init-data.clj` to your database using `mongo.clj`.

    $ lein repl
    ...
    tweetbot.main=> (load-file "src/tweetbot/mongo.clj")

## Run

    $ lein run

This will fetch a random message from the database you specified in `db-conf.clj` and tweet it,
periodically. You can specify the time interval in `-main` function in `main.clj`.
