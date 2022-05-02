(ns simple-pig-latin.core-test
  (:require [clojure.test :refer :all]
            [simple-pig-latin.core :refer :all]))

(deftest pig-latin-example-test
  (is (= (pig-it "Pig latin is cool") "igPay atinlay siay oolcay")))

(deftest pig-latin-example-test
  (is (= (pig-it "This is my string") "hisTay siay ymay tringsay")))

(deftest pig-latin-example-test
  (is (= (pig-it "This is . my string !") "hisTay siay . ymay tringsay !")))
