(ns testing-the-porges-hypothesis.core-test
  (:require [clojure.test :refer :all]
            [testing-the-porges-hypothesis.core :refer :all]))

(deftest sum-digit-squares-test
  (testing "single digit"
    (is (= (sum-digit-squares 1) 1))
    (is (= (sum-digit-squares 2) 4))
    (is (= (sum-digit-squares 3) 9))
    (is (= (sum-digit-squares 4) 16))
    (is (= (sum-digit-squares 5) 25))
    )
  (testing "multi digit"
    (is (= (sum-digit-squares 10) 1))
    (is (= (sum-digit-squares 16) 37))
    (is (= (sum-digit-squares 37) 58))
    (is (= (sum-digit-squares 49) 97))
    (is (= (sum-digit-squares 97) 130))
    (is (= (sum-digit-squares 130) 10))
    )
  )

(deftest porges-test
  (testing "no cycle porges"
    (is (= (porges-cycle 1) -1))
    (is (= (porges-cycle 7) -1))
    )
  (testing "cycled porges"
    (is (= (porges-cycle 2) 4))
    (is (= (porges-cycle 4) 4))
    (is (= (porges-cycle 9) 37))
    ))
