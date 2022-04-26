(ns playing-with-passphrases.core-test
  (:require [clojure.test :refer :all]
            [playing-with-passphrases.core :refer :all]))

(deftest rot-test
  (testing "no overflow"
    (is (= (rot "A" 1) "B"))
    (is (= (rot "A" 3) "D"))
    (is (= (rot "F" 1) "G"))
    (is (= (rot "T" 1) "U"))
    (is (= (rot "A" 16) "Q"))
    )
  (testing "overflow"
    (is (= (rot "Z" 1) "A"))
    (is (= (rot "T" 8) "B"))
    )
  )

(deftest complement-to-9-test
  (testing "complement to 9"
    (is (= (complement-to-9 "1") "8"))
    (is (= (complement-to-9 "2") "7"))
    (is (= (complement-to-9 "0") "9"))
    (is (= (complement-to-9 "9") "0"))
    )
  )

(deftest encode-char-test
  (testing "letter"
    (is (= (encode-char "A" 1) "B"))
    (is (= (encode-char "A" 3) "D"))
    (is (= (encode-char "F" 1) "G"))
    (is (= (encode-char "T" 1) "U"))
    (is (= (encode-char "A" 16) "Q"))
    )
  (testing "number"
    (is (= (encode-char "8" 1) "1"))
    (is (= (encode-char "5" 8) "4"))
    )
  (testing "special char"
    (is (= (encode-char " " 1) " "))
    (is (= (encode-char ":" 8) ":"))
    (is (= (encode-char "!" 8) "!"))
    )
  )

(deftest update-case-test
  (testing "letter"
    (is (= (update-case "A" 1) "A"))
    (is (= (update-case "A" 2) "a"))
    )
  (testing "other"
    (is (= (update-case "1" 2) "1"))
    (is (= (update-case "!" 2) "!"))
    )
  )

(deftest sponge-bob-case-test
  (testing "letters"
    (is (= (sponge-bob-case ["A" "A" "A" "A" "A" "A" "A" "A" "A"]) ["A" "a" "A" "a" "A" "a" "A" "a" "A"]))
    )
  )

(deftest a-test1
  (testing "Test1"
    (is (= (play-pass "I LOVE YOU!!!" 1) "!!!vPz fWpM J"))))

(deftest a-test4
  (testing "Test4"
    (is (= (play-pass "MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015" 2)
           "4897 NkTrC Hq fT67 GjV Pq aP OqTh gOcE CoPcTi aO"))))
