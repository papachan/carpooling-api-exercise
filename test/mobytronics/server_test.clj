(ns mobytronics.server-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request json-body]]
            [mobytronics.router :refer [app]]))


(deftest server-api-test
  (testing "GET request"
    (is (= (-> (request :get "/ping") app :body) "pong"))))
