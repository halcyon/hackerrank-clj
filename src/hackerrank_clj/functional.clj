(ns hackerrank-clj.functional)

(defn filter-array []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        delimiter (Integer/parseInt (first in))
        list_to_filter (map #(Integer/parseInt %) (rest in))]
    ((fn[delim lst]
       (dorun (map println
                   (filter #(> delim %1)
                           lst)))) delimiter list_to_filter)))

(defn filter-odd-positions []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        list_to_filter (map #(Integer/parseInt %) in)]
    ((fn[lst]
       (dorun (map println
                   (take-nth 2 (rest lst))))) list_to_filter)))
