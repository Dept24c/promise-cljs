(defproject promise-cljs "0.1.0-SNAPSHOT"
  :description "ClojureScript wrapper for bluebird.js"
  :url "http://github.com/Dept24c/promise-cljs"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]]

  :plugins [[lein-cljsbuild "1.1.7"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "target"]
  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src"]
     :figwheel     {:on-jsload "promise-cljs.core/init"}
     :compiler     {:main                 promise-cljs.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :optimizations        :none
                    :verbose              true
                    :npm-deps             {:bluebird "3.5.1"}
                    :install-deps         true
                    :closure-warnings     {:non-standard-jsdoc :off}}}]}

  :jar-exclusions [#"^public/"])
