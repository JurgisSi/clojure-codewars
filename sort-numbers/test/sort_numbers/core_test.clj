(ns sort-numbers.core-test
  (:require [clojure.test :refer :all]
            [sort-numbers.core :refer :all]))

(deftest basic-tests
  (is (= (solution [1 2 3 10 5]) [1 2 3 5 10]))
  (is (= (solution nil) []))
  (is (= (solution []) []))
  (is (= (solution [20 2 10]) [2 10 20]))
  (is (= (solution [2 20 10]) [2 10 20])))
