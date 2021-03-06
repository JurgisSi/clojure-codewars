(ns weight-for-weight.core-test
  (:require [clojure.test :refer :all]
            [weight-for-weight.core :refer :all]))

(deftest a-test1
  (testing "Basic tests"
    (is (= (order-weight "103 123 4444 99 2000") "2000 103 123 4444 99"))
    (is (= (order-weight "2000 10003 1234000 44444444 9999 11 11 22 123") "11 11 2000 10003 22 123 1234000 44444444 9999"))))
