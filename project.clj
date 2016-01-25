(defproject rsvp "0.1.0-SNAPSHOT"
  :description "RSVP"
  :url "http://github.com/cryptohack/rsvp"

  :plugins [[lein-midje "3.1.1"]]

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring "1.4.0"]
                 [ring/ring-json "0.4.0"]
                 [compojure "1.1.6"]
                 [ring/ring-mock "0.3.0"]
                 [midje "1.8.3"]
                 [cheshire "5.5.0"]]
  :aot  [rsvp.core]

  :main rsvp.core)
