(ns hackerrank-clj.thirty-days-test
  (:require [clojure.test :refer :all]
            [hackerrank-clj.thirty-days :refer :all]
            [hackerrank-clj.util :refer [wrap-io]]))

(deftest operators-test
  (is (= "The total meal cost is 15 dollars.\n"
         (wrap-io operators (str "12.00\n"
                                 "20\n"
                                 "8\n")))))

(deftest intro-to-cond-test
  (are [in out] (= out (wrap-io intro-to-cond in))
    "3" "Weird\n"
    "4" "Not Weird\n"
    "6" "Weird\n"
    "10" "Weird\n"
    "15" "Weird\n"
    "20" "Weird\n"
    "22" "Not Weird\n"
    "24" "Not Weird\n"))

(deftest factorial-test
  (is (= "6\n"
         (wrap-io factorial (str "3\n")))))
