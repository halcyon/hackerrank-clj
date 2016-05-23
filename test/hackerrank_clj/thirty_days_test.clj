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

(deftest loops-test
  (is (= (str "2 x 1 = 2\n"
              "2 x 2 = 4\n"
              "2 x 3 = 6\n"
              "2 x 4 = 8\n"
              "2 x 5 = 10\n"
              "2 x 6 = 12\n"
              "2 x 7 = 14\n"
              "2 x 8 = 16\n"
              "2 x 9 = 18\n"
              "2 x 10 = 20\n")
         (wrap-io loops (str "2\n")))))

(deftest review-loop-test (is (= (str "Funny\n"
                                      "Not Funny\n")
                                 (wrap-io review-loop (str "2\n"
                                                           "acxz\n"
                                                           "bcxz\n")))))

(deftest array-test (is (= "2 3 4 1\n"
                           (wrap-io array (str "4\n"
                                               "1 4 3 2\n")))))

(deftest factorial-test
  (is (= "6\n"
         (wrap-io factorial "3\n"))))


(deftest max-consecutive-1s-test
  (is (= "1\n"
         (wrap-io max-consecutive-1s "5\n")))
  (is (= "2\n"
         (wrap-io max-consecutive-1s "13\n"))))

(deftest max-hourglass-test
  (is (= "19\n"
         (wrap-io max-hourglass (str "1 1 1 0 0 0\n"
                                     "0 1 0 0 0 0\n"
                                     "1 1 1 0 0 0\n"
                                     "0 0 2 4 4 0\n"
                                     "0 0 0 2 0 0\n"
                                     "0 0 1 2 4 0\n")))))

(deftest prime-detection-test
  (is (= (str "Not prime\n"
              "Prime\n"
              "Prime\n")
         (wrap-io prime-detection (str "3\n"
                                       "12\n"
                                       "5\n"
                                       "7\n")))))

(deftest library-fee-test
  (is (= (str "45\n")
         (wrap-io library-fees (str "9 6 2015\n"
                                    "6 6 2015\n")))))

(deftest class-cancellation-test
  (is (= (str "YES\n")
         (wrap-io class-cancellation (str "2\n"
                                          "2 1\n"
                                          "0 -1\n"))))
  (is (= (str "NO\n")
         (wrap-io class-cancellation (str "2\n"
                                          "3 3\n"
                                          "0 -1 4\n"))))
  (is (= (str "YES\n")
         (wrap-io class-cancellation (str "1\n"
                                          "4 2\n"
                                          "0 -3 4 2\n"))))
  (is (= (str "NO\n")
         (wrap-io class-cancellation (str "1\n"
                                          "5 3\n"
                                          "0 -3 4 2 1\n"))))
  (is (= (str "YES\n")
         (wrap-io class-cancellation (str "1\n"
                                          "6 2\n"
                                          "0 -3 4 2 1 6\n")))))


(deftest sort-emails-test
  (is (= (str "julia\n"
              "julia\n"
              "riya\n"
              "samantha\n"
              "tanya\n")
         (wrap-io sort-emails (str "6\n"
                                   "riya riya@gmail.com\n"
                                   "julia julia@julia.me\n"
                                   "julia sjulia@gmail.com\n"
                                   "julia julia@gmail.com\n"
                                   "samantha samantha@gmail.com\n"
                                   "tanya tanya@gmail.com\n")))))


(deftest bitwise-problem-test
  (is (= (str "1\n"
              "4\n"
              "0\n"
              "5\n")
         (wrap-io bitwise-problem (str "3\n"
                                       "5 2\n"
                                       "8 5\n"
                                       "2 2\n"
                                       "9000 6")))))
