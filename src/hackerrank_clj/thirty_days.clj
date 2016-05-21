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

(defn fact-tail
  [n]
  (loop [cnt n acc 1N]
    (if (zero? cnt)
      acc
      (recur (dec cnt) (* acc cnt))
                                        ; in loop cnt will take the value (dec cnt)
                                        ; and acc will take the value (* acc cnt)
      )))

(defn factorial []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))]
    (println (fact number))))

(defn dec-to-base
  [n radix]
  (loop [i n acc []]
    (if (zero? i)
      acc
      (recur (quot i radix)
             (conj acc (mod i radix))))))

(defn max-consec
  [n coll]
  (apply max (map count
                  (filter #(= n (first %))
                          (partition-by identity coll)))))

(defn max-consecutive-1s []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (Integer/parseInt (first in))
        radix 2
        consecutives 1]
    (println (max-consec consecutives (dec-to-base number radix)))))

(defn find-hourglass-max
  [coll]
  (let [columns 6
        position {:upper-left 0
                  :upper-center 1
                  :upper-right 2
                  :center 7
                  :lower-left 12
                  :lower-center 13
                  :lower-right 14}
        shifts 4]
    (loop [j 0 acc []]
      (if (< j shifts)
        (recur (inc j)
               (concat acc
                       (loop [i 0 hourglass []]
                         (if (< i shifts)
                           (recur (inc i)
                                  (conj hourglass
                                        (+ (nth coll (+ i (:upper-left position)
                                                        (* columns j)))
                                           (nth coll (+ i (:upper-center position)
                                                        (* columns j)))
                                           (nth coll (+ i (:upper-right position)
                                                        (* columns j)))
                                           (nth coll (+ i (:center position)
                                                        (* columns j)))
                                           (nth coll (+ i (:lower-left position)
                                                        (* columns j)))
                                           (nth coll (+ i (:lower-center position)
                                                        (* columns j)))
                                           (nth coll (+ i (:lower-right position)
                                                        (* columns j))))))
                           hourglass))))
        (apply max acc)))))

(defn valid-n?
  [n]
  (<= (mod n 6) 3))

(defn hourglass
  [i [a b c _  _ _ _ d _ _ _ _ e f g]]
  (when (valid-n? i)
    [a b c d e f g]))

(defn gen-all-hourglasses
  [data]
  (keep identity
        (map-indexed
         hourglass
         (map #(drop % data) (range 22)))))

(defn compute-hourglass-max
  [data]
  (apply max (map (partial reduce +)
                  (gen-all-hourglasses data))))

(defn max-hourglass []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        matrix (map #(Integer/parseInt %) in)]
    (println (compute-hourglass-max matrix))))

(defn prime-detector
  [n]
  (if (< n 2)
    false
    (not-any? zero?
              (map (partial mod n)
                   (range 2 (Math/sqrt n))))))

(defn prime-detection []
  (let [in (clojure.string/split (slurp *in*) #"\s")
        number (#(Integer/parseInt %) (first in))
        lines (rest in)]
    (dorun (map (comp #(if % (println "Prime") (println "Not prime"))
                      prime-detector
                      #(Integer/parseInt %))
                lines))))
