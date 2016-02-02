(ns rsvp.core
  (:require
    [ring.adapter.jetty :as ring-jetty]
    [compojure.core :refer [defroutes routes GET POST]]
    [ring.middleware.params :refer [wrap-params]]
    [ring.util.response :refer [response]]
    [clojure.java.io :as io])
  (:gen-class))

(defn rsvp-handler [req]
  (prn req)
  (let [params (:params req)]
    (spit "rsvps.csv"
          (str (params "name") "," (params "email") "," (params "github") "\n")
          :append true))
  {:status 201})

(def app
  (-> (routes (POST "/rsvp" [] rsvp-handler))
      wrap-params))

(defn -main []
  (let [port 8080]
    (ring-jetty/run-jetty app {:port port})))
