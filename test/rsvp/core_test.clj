(ns rsvp.core-test
  (:require [midje.sweet :refer :all]
            [rsvp.core :as core]
            [ring.mock.request :as mock]))

(facts "about app"
  (fact "rsvp works"
    (let [response (-> (mock/request :post "/rsvp") core/app)]
      (:status response) => 201)))

