(ns mobytronics.scrapper
  (:require [net.cgrand.enlive-html :as html]))

;; Scrapping a web page and use enlive to parse html data

(def strings->keys
  {"Non-smoke car:" :non-smoke-car
   "Name:" :name
   "Email:" :email
   "Mobile:" :mobile
   "Phone:" :phone
   "Seats:" :seats})

(defn lookup-page
  "Fetch as resource a web page"
  [url]
  (-> url
      (java.net.URL. )
      (html/html-resource)))

(defn table->map [table]
  "Transform an html data structure into a map structure"
  (apply merge
         (map
          (fn [tr]
            (let [td (html/select tr [:td])]
              (zipmap
               (-> td
                   first
                   :content
                   first
                   :content)
               (-> td
                   second
                   :content))))
          (html/select table [:tr]))))

(defn parse-html-content
  "Parse html content into a hashmap"
  [resource]
  (if-let [content (-> resource
                       (html/select [:table]))]
    (-> content
        (table->map)
        (clojure.set/rename-keys strings->keys)
        (select-keys (vals strings->keys)))))
