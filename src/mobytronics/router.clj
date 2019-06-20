(ns mobytronics.router
  (:require [reitit.ring :as ring]
            [reitit.ring.coercion :as rrc]
            [reitit.coercion.spec :as rcs]
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [muuntaja.core :as m]
            [mobytronics.handler :as hd]))


;; Routing
(def router ["" {:no-doc true
                 :swagger {:info {:title "car-api"
                                  :description "https://cljdoc.org/d/metosin/reitit"}}}
             ["/swagger.json"
              {:get (swagger/create-swagger-handler)}]
             ["/ping"
              {:get (fn [_]
                      {:status 200
                       :body "pong"})}]
             ["/passengers" {:swagger {:tags ["passengers"]}
                             :get {:summary "get all passengers data"
                                   :handler hd/passengers-handler}}]
             ["/drivers" {:swagger {:tags ["drivers"]}
                          :get {:summary "get all drivers data"
                                :handler hd/drivers-handler}}]])

;; App handler
(def app
  (ring/ring-handler
   (ring/router
    router
    {:data {:muuntaja m/instance
            :coercion rcs/coercion
            :middleware [muuntaja/format-middleware
                         rrc/coerce-exceptions-middleware
                         rrc/coerce-request-middleware
                         rrc/coerce-response-middleware]}})
   (ring/routes
    (swagger-ui/create-swagger-ui-handler
     {:path "/"
      :config {:validator-url nil}})
    (ring/create-default-handler))))
