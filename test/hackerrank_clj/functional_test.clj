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

(deftest filter-odd-positions-test
  (is (= (str "5\n"
              "4\n"
              "7\n"
              "8\n")
         (wrap-io filter-odd-positions (str "2\n"
                                          "5\n"
                                          "3\n"
                                          "4\n"
                                          "6\n"
                                          "7\n"
                                          "9\n"
                                          "8\n")))))

(deftest process-rows-test
  (is (= [["Radnor - Fort Myer Heights" "Virginia/Arlington/Radnor---Fort-Myer-Heights" "18412"]]
         (process-rows "Radnor - Fort Myer Heights^Virginia/Arlington/Radnor---Fort-Myer-Heights^18412")))
  (is (= [["Downtown Cleveland" "Ohio/Cleveland/Downtown-Cleveland" "7949"]
          ["CSU - Euclid Corridor" "Ohio/Cleveland/CSU---Euclid-Corridor" "831845"]
          ["Campus District" "Ohio/Cleveland/Campus-District" "831839"]]
         (process-rows "Downtown Cleveland^Ohio/Cleveland/Downtown-Cleveland^7949^+^CSU - Euclid Corridor^Ohio/Cleveland/CSU---Euclid-Corridor^831845^+^Campus District^Ohio/Cleveland/Campus-District^831839"))))
