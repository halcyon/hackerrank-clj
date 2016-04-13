(ns hackerrank-clj.functional-test
  (:require [hackerrank-clj.functional :refer :all]
            [clojure.test :refer :all]
            [hackerrank-clj.util :refer [wrap-io]]))

(deftest filter-array-test
  (is (= (str "2\n"
              "1\n"
              "0\n")
         (wrap-io filter-array (str "3\n"
                                    "10\n"
                                    "9\n"
                                    "8\n"
                                    "2\n"
                                    "7\n"
                                    "5\n"
                                    "1\n"
                                    "3\n"
                                    "0\n")))))
