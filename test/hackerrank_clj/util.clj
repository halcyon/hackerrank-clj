(ns hackerrank-clj.util)

(defn wrap-io
  [f ^String in]
  (with-in-str in (with-out-str (f))))
