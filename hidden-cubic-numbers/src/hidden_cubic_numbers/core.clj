(ns hidden-cubic-numbers.core
  (:require [clojure.string]))

(defn split-to-three-digit-numbers [input]
  (re-seq #".{1,3}" input)
  )

(defn split-to-digits-groups [input]
  (clojure.string/split input #"\D+")
  )

(defn parse-input [input]
  (flatten (map #(split-to-three-digit-numbers %) (split-to-digits-groups input)))
  )

(defn sum-digit-cubes [number]
  (reduce + (map #(* % % %) (map #(Integer/parseInt %) (clojure.string/split number #""))))
  )

(defn is-cubic? [number]
  (if (empty? number)
    false
    (let [orig (Integer/parseInt number)
          sum (sum-digit-cubes number)]
      (= orig sum)))
  )

(defn sum-cubes [s]
  (let [cubic (map #(Integer/parseInt %) (filter #(is-cubic? %) (parse-input s)))]
    (if (empty? cubic)
      "Unlucky"
      (str (clojure.string/join " " cubic) " " (reduce + cubic) " Lucky")
      )
    )
  )
