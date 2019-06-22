(ns mobytronics.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [mobytronics.router :as rs]))


(defn start
  [fn]
  (do
      (jetty/run-jetty fn {:port 3000})
      (println "server running in port 3000")))

(defn -main
  [& args]
  (start #'rs/app))

(defn -dev-main
  [& args]
  (start (wrap-reload #'rs/app)))


(comment
  (start #'rs/app)

)
