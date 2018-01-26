(ns promise-cljs.core
  (:require [bluebird :refer [Promise]]))

(def debug?
  ^boolean goog.DEBUG)

(when debug?
  (enable-console-print!))

;; general CLJS initialiation function
(defn ^:export init []
  (when debug?
    (println "-- init --")
    (let [resolve-reject (fn [resolve] (resolve "foo"))
          hello (new js/Promise resolve-reject)]
      (.then hello #(println "got" %)))))
