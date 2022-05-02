(ns array-diff.core-test
  (:require [clojure.test :refer :all]
            [array-diff.core :refer :all]))

(deftest example-tests
  (is (= (array-diff [1 2] [1]) [2]))
  (is (= (array-diff [1 2 2] [1]) [2 2]))
  (is (= (array-diff [1 2 2] [2]) [1]))
  (is (= (array-diff [1 2 2] []) [1 2 2]))
  (is (= (array-diff [1 2 3] [1 2]) [3]))
  (is (= (array-diff [] [1 2]) [])))
