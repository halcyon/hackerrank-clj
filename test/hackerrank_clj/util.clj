(ns hackerrank-clj.util
  (:require  [clojure.test :as t]))

(defn wrap-io
  [f ^String in]
  (with-in-str in (with-out-str (f))))
