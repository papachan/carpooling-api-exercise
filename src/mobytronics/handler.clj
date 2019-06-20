(ns mobytronics.handler
  (:require [reitit.core :as r]
            [schema.core :as s]
            [reitit.coercion :as coercion]
            [reitit.coercion.schema]
            [clj-http.client :as client])
  (:use [mobytronics.constants]
        [mobytronics.scrapper]))

(defn get-results-from-url
  [type]
  (-> (format "%s/rides/samferda-%s/" base-url type)
      (client/get {:as :json :insecure? true})
      :body
      :results))

(def parse-link-data
  (fn [m]
    (if-let [link (get m :link)]
      (concat m (parse-html-content (lookup-page link))))))

(defn get-all-links
  "get all additional data in a vector"
  [type]
  (let [response (get-results-from-url type)]
    (map parse-link-data response)))

(defn passengers-handler [_]
  (let [body-str (get-all-links "passengers")]
    {:status 200, :body {:response body-str}}))

(defn drivers-handler [_]
  (let [body-str (get-all-links "drivers")]
    {:status 200, :body {:response body-str}}))
