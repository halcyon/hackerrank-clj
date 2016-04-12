(ns hackerrank-clj.thirty-days)

(defn operators []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        meal-cost (Double/parseDouble (nth in 0))
        tip-rate (/ (Integer/parseInt (nth in 1))
                    100)
        tax-rate (/ (Integer/parseInt (nth in 2))
                    100)
        tip (* meal-cost tip-rate)
        tax (* meal-cost tax-rate)
        total-cost (Math/round (+ meal-cost tip tax))]
    (println (str "The total meal cost is "
                  total-cost
                  " dollars."))))

(defn intro-to-cond []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))]
    (cond
      (odd? number) (println "Weird")
      (<= 2 number 5) (println "Not Weird")
      (<= 6 number 20)  (println "Weird")
      (> number 20) (println "Not Weird"))))
