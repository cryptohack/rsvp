(ns rsvp.core
  (:require
    [ring.adapter.jetty :as ring-jetty]
    [compojure.core :refer [defroutes routes GET POST]]
    [ring.middleware.json :as middleware]
    [ring.util.response :refer [response]])
  (:gen-class))

(defn rsvp-handler [req]
  {:status 201}
)

(def app
  (middleware/wrap-json-body
    (routes
      (POST "/rsvp" [] rsvp-handler))
    {:keywords? true}))

(defn -main []
  (let [port 8080]
    (ring-jetty/run-jetty app {:port port})))
