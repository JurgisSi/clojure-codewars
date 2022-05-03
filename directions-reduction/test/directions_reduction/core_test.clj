(ns directions-reduction.core-test
  (:require [clojure.test :refer :all]
            [directions-reduction.core :refer :all]))

(deftest a-test1
  (testing "Test 1"
    (def ur ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"])
    (def vr ["WEST"])
    (is (= (dirReduc ur) vr)))
  (testing "Test 2"
    (def ur ["NORTH", "SOUTH", "EAST", "WEST"])
    (def vr nil)
    (is (= (dirReduc ur) vr)))
  (testing "Test 3"
    (def ur ["NORTH", "WEST", "SOUTH", "EAST"])
    (def vr ["NORTH", "WEST", "SOUTH", "EAST"])
    (is (= (dirReduc ur) vr)))
  (testing "Test 4"
    (def ur ["NORTH"])
    (def vr ["NORTH"])
    (is (= (dirReduc ur) vr)))
  (testing "Test 4"
    (def ur [])
    (def vr nil)
    (is (= (dirReduc ur) vr)))
  (testing "Test 4"
    (def ur ["NORTH" "SOUTH" "SOUTH" "EAST" "WEST" "NORTH"])
    (def vr nil)
    (is (= (dirReduc ur) vr))))