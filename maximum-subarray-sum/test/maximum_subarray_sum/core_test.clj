(ns maximum-subarray-sum.core-test
  (:require [clojure.test :refer :all]
            [maximum-subarray-sum.core :refer :all]))

(deftest simple
  (is (= (max-sequence  [-2, 1, -3, 4, -1, 2, 1, -5, 4]) 6)))

(deftest empty
  (is (= (max-sequence  []) 0)))

(deftest negative
  (is (= (max-sequence  [-2, -1, -3, -4, -1, -2, -1, -5, -4]) 0)))
