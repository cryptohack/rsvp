(ns rsvp.core
  (:require
    [ring.adapter.jetty :as ring-jetty]
    [compojure.core :refer [defroutes routes GET POST]]
    [ring.middleware.json :as middleware]
    [ring.util.response :refer [response]]
    [clojure.java.io :as io])
  (:gen-class))

(defn rsvp-handler [req]
  (prn req)
  (spit "rsvps.edn"
        (str (:body req) "\n")
        :append true)
  {:status 201})

(def app
  (-> (routes (POST "/rsvp" [] rsvp-handler))
      (middleware/wrap-json-body {:keywords? true})))

(defn -main []
  (let [port 8080]
    (ring-jetty/run-jetty app {:port port})))
