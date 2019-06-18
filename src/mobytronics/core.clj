(ns mobytronics.core
  (:require [reitit.ring :as ring]
            [ring.adapter.jetty :as jetty]))

;; Routing
(def router [["/ping"
              {:get (fn [_]
                      {:status 200
                       :body "pong"})}]])

;; App handler
(def app
  (ring/ring-handler
   (ring/router
    router)
   (ring/create-default-handler)))


(defn -main
  [& args]
  (do
      (jetty/run-jetty #'app {:port 3000})
      (println "server running in port 3000")))
