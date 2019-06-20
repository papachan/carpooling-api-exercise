(ns mobytronics.core-test
  (:require [clojure.test :refer :all]
            [net.cgrand.enlive-html :as html]
            [mobytronics.scrapper :refer :all]))

(defn fetch-file
  "Fetch file as resource from project resources files"
  [file-path]
  (html/html-resource (java.io.StringReader. (slurp file-path))))

(deftest test-html-parser
  (testing "testing html parser with ride data"
    (let [resource (fetch-file "resources/html/ride.html")
          result (parse-html-content resource)]
      (is (= result {:seats "3",
                     :name "Davíð adessa",
                     :mobile "8679191",
                     :non-smoke-car "yes"})))))
