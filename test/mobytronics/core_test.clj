(ns mobytronics.core-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request json-body]]
            [mobytronics.core :refer [app]]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

(deftest server-api-test
  (testing "GET request"
    (is (= (-> (request :get "/ping") app :body) "pong"))))
