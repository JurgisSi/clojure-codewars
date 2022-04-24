(ns rgb-to-hex-conversion.core-test
  (:require [clojure.test :refer :all]
            [rgb-to-hex-conversion.core :refer :all]))

(deftest normalize-test
  (testing "normalize"
    (is (= (normalize "0") "00"))
    (is (= (normalize "5") "05"))
    (is (= (normalize "FF") "FF"))
    (is (= (normalize "F") "0F"))
    ))

(deftest to-hex-test
  (testing "to hex"
    (is (= (to-hex 0) "00"))
    (is (= (to-hex 5) "05"))
    (is (= (to-hex 255) "FF"))
    (is (= (to-hex 173) "AD"))
    (is (= (to-hex 47) "2F"))
    ))

(deftest limit-test
  (testing "in limit"
    (is (= (limit 0) 0))
    (is (= (limit 5) 5))
    (is (= (limit 255) 255))
    (is (= (limit 173) 173))
    (is (= (limit 47) 47))
    )
  (testing "lower"
    (is (= (limit -50) 0))
    (is (= (limit -1) 0))
    (is (= (limit -10215) 0))
    )
  (testing "higher"
    (is (= (limit 256) 255))
    (is (= (limit 300) 255))
    (is (= (limit 16516) 255))
    )
  )

(deftest rgb-test
  (testing "0 0 0"
    (is (= (rgb 0 0 0) "000000")))
  (testing "0 0 -20"
    (is (= (rgb 0 0 -20) "000000")))
  (testing "300 255 255"
    (is (= (rgb 300 255 255) "FFFFFF")))
  (testing "173 255 47"
    (is (= (rgb 173 255 47) "ADFF2F")))
  (testing "148 0 211"
    (is (= (rgb 148 0 211) "9400D3"))))