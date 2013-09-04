;; mongohq connection information

{:db-uri (let [id "your-mongodb-user-id"
               pw "your-mongodb-user-pw"]
           (format "mongodb://%s:%s@paulo.mongohq.com:<port>/your-mongodb-name" id pw))}
