(ns rsvp.core-test
  (:require [midje.sweet :refer :all]
            [rsvp.core :as core]
            [ring.mock.request :as mock]
            [clojure.java.io :as io]))

(facts "about app"
  (fact "rsvp works"
    (let [response (->
                     (mock/request :post "/rsvp")
                     (mock/body {:name "namo" :github "github_namo" :email "whatsit@example.com"})
                     core/app)]
      (:status response) => 201

      (with-open [reader (io/reader "rsvps.csv")]
        (last (line-seq reader)) => "namo,whatsit@example.com,github_namo"))))
