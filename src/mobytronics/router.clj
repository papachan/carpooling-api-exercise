(ns mobytronics.router
  (:require [reitit.ring :as ring]
            [reitit.ring.coercion :as rrc]
            [reitit.coercion.spec :as rcs]
            [reitit.swagger :as swagger]
            [reitit.swagger-ui :as swagger-ui]
            [reitit.ring.middleware.muuntaja :as muuntaja]
            [muuntaja.core :as m]
            [mobytronics.handler :refer :all]))


;; Routing
(def router [["/swagger.json"
               {:get {:no-doc true
                      :swagger {:info {:title "car-api"
                                       :description "https://cljdoc.org/d/metosin/reitit"}}
                      :handler (swagger/create-swagger-handler)}}]

              ["/passengers" {:get {:summary "get passengers data (response json)"
                                    :handler (fn [_]
                                               (handler "passengers"))}}]
              ["/drivers" {:get {:summary "get drivers data (response json)"
                                 :handler (fn [_]
                                            (handler "drivers"))}}]])

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
