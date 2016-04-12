(ns hackerrank-clj.thirty-days-test
  (:require [clojure.test :refer :all]
            [hackerrank-clj.thirty-days :refer :all]))

(deftest operators-test
  (let [in (str "12.00\n"
                "20\n"
                "8\n")
        out "The total meal cost is 15 dollars.\n"]
    (is (= out
           (with-in-str in (with-out-str (total-meal-cost)))))))


(deftest intro-to-cond-test
  (are [in out] (= out
                   (with-in-str in (with-out-str (intro-to-cond))))
    "3" "Weird\n"
    "4" "Not Weird\n"
    "6" "Weird\n"
    "10" "Weird\n"
    "15" "Weird\n"
    "20" "Weird\n"
    "22" "Not Weird\n"
    "24" "Not Weird\n"))
