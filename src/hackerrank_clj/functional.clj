(ns hackerrank-clj.functional)

(defn filter-array []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        delimiter (Integer/parseInt (first in))
        list_to_sort (map #(Integer/parseInt %) (rest in))]
    ((fn[delim lst]
       (dorun (map println
                   (filter #(> delim %1)
                           lst)))) delimiter list_to_sort)))
