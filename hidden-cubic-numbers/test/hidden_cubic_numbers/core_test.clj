(ns hidden-cubic-numbers.core-test
  (:require [clojure.test :refer :all]
            [hidden-cubic-numbers.core :refer :all]))

(deftest split-to-digits-groups-test
  (testing "split non digit characters"
    (is (= (split-to-digits-groups "0 9026315 -827&()") '("0" "9026315" "827")))))

(deftest split-to-three-digit-numbers-test
  (testing "split to 3 digit numbers"
    (is (= (split-to-three-digit-numbers "9026315") '("902" "631" "5")))))

(deftest parse-input-test
  (testing "prepare input"
    (is (= (parse-input "0 9026315 -827&()") '("0" "902" "631" "5" "827")))))

(deftest sum-digit-cubes-test
  (testing "single digit"
    (is (= (sum-digit-cubes "0") 0))
    (is (= (sum-digit-cubes "1") 1))
    (is (= (sum-digit-cubes "3") 27))
    )
  (testing "multi digit"
    (is (= (sum-digit-cubes "153") 153))
    (is (= (sum-digit-cubes "902") 737))
    )
  )

(deftest is-cubic?-test
  (testing "cubic numbers"
    (is (= (is-cubic? "0") true))
    (is (= (is-cubic? "1") true))
    (is (= (is-cubic? "153") true))
    )
  (testing "non cubic numbers"
    (is (= (is-cubic? "2") false))
    (is (= (is-cubic? "902") false))
    )
  )

(deftest sum-cubes-test
  (testing "lucky"
    (is (= (sum-cubes "aqdf&0#1xyz!22[153(777.777") "0 1 153 154 Lucky"))
    (is (= (sum-cubes "153000153407000407") "153 0 153 407 0 407 1120 Lucky"))
    )
  (testing "unlucky"
    (is (= (sum-cubes "QK29a45[&erui9026315") "Unlucky"))
    )
  )
