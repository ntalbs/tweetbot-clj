Tweetbot
========

Simple tweet bot written in Clojure.

## Setup
Clone this project, copy `_config.clj` to `config.clj`.

    $ git clone https://github.com/ntalbs/tweetbot-clj.git
    $ cd tweetbot-clj/src/tweetbot
    $ cp _config.clj config.clj

After the above steps, edit `config.clj` to fill the oauth credentials and database uri.

## Loading initial data
You can load initial data in `init-data.clj` to your database using `mongo.clj`.

    $ lein repl
    ...
    tweetbot.main=> (load-file "src/tweetbot/mongo.clj")

## Run

    $ lein run

This will fetch a random message from the database you specified in `config.clj` and tweet it, periodically. You can specify the interval by setting `:tweet-interval` property in the config file.
