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

(defn loops []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))]
    (loop [n 1]
      (when (<= n 10)
        (println number "x" n "=" (* number n))
        (recur (inc n))))))

(defn pairs
  [s]
  (->> s
       rest
       (interleave s)
       (partition 2)))

(defn distance
  [s]
  (map #(Math/abs (- (int (second %))
                     (int (first %))))
       (pairs s)))

(defn funny?
  [s]
  (= (distance s)
     (distance (reverse s))))

(defn funny-printer
  [s]
  (if (funny? s)
      (println "Funny")
      (println "Not Funny")))

(defn review-loop []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))
        lines (rest in)]
    (dorun (map funny-printer lines))))

(defn array []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))
        array (rest in)]
    (apply println (reverse array))))

(defn fact [n]
  (if (= n 1)
    1
    (* n (fact (dec n)))))

(defn factorial []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))]
    (println (fact number))))
