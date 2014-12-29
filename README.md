Tweetbot
========

Simple tweet bot written in Clojure.

## Setup
Clone this project.

    $ git clone https://github.com/ntalbs/tweetbot-clj.git

Set environment variables.

    $ export TWEETBOT_TWITTER_CONSUMER_KEY=...
    $ export TWEETBOT_TWITTER_CONSUMER_SECRET=...
    $ export TWEETBOT_TWITTER_ACCESS_TOKEN=...
    $ export TWEETBOT_TWITTER_ACCESS_TOKEN_SECRET=...
    $ export TWEETBOT_DB_URI=...

## Loading initial data
You can load initial data in `init-data.clj` to your database using `mongo.clj`.

    $ lein repl
    ...
    tweetbot.main=> (load-file "src/tweetbot/mongo.clj")

## Run

    $ lein run

This will fetch a random message from the database you specified in `config.clj` and tweet it, periodically. You can specify the interval by setting `:tweet-interval` property in the config file.
