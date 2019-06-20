(ns mobytronics.server-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request json-body]]
            [mobytronics.router :refer [app]]
            [cheshire.core :as json]))

(deftest server-api-test
  (testing "GET /passengers endpoint"
    (let [response (-> (request :get "/passengers") app)
          json-response (json/parse-string (slurp (:body response)) true)]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"}))
      (is (some? (:response json-response)))))

  (testing "GET /drivers endpoint"
    (let [response (-> (request :get "/drivers") app)
          json-response (json/parse-string (slurp (:body response)) true)]
      (is (= (:status response) 200))
      (is (= (:headers response) {"Content-Type" "application/json; charset=utf-8"}))
      (is (some? (:response json-response))))))
