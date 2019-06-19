(defproject mobytronics "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [metosin/reitit "0.3.9"]
                 [ring "1.7.1"]]
  :target-path "target/%s"
  :repl-options {:init-ns mobytronics.core}
  :main ^:skip-aot mobytronics.core/-main
  :profiles {:dev {:dependencies [[ring/ring-mock "0.3.2"]]
                   :plugins [[com.jakemccrary/lein-test-refresh "0.24.1"]]}
             :uberjar {:aot :all}})
