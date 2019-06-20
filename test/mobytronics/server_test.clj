(ns mobytronics.server-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :refer [request json-body]]
            [mobytronics.router :refer [app]]
            [muuntaja.core :as m]))


(deftest server-api-test
  (testing "GET /passengers request"
    (let [response (-> (request :get "/passengers") app)]
      (is (= (:status response) 200)
          (= (:headers response) "{Content-Type application/json; charset=utf-8}"))))

  (testing "GET /drivers request"
    (let [response (-> (request :get "/drivers") app)]
      (is (= (:status response) 200)
          (= (:headers response) "{Content-Type application/json; charset=utf-8}")))))
