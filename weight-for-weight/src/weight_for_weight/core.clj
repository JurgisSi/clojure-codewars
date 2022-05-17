(ns weight-for-weight.core)

(defn calculate-weight [value]
  (->>
    (char-array value)
    (map #(Character/digit ^char % 10))
    (reduce +)
    )
  )

(defn weight-comparator
  [one two]
  (let [result (- (calculate-weight one) (calculate-weight two))]
    (if (not= result 0)
      result
      (compare one two))
    )
  )

(defn order-weight [strng]
  (->>
    (clojure.string/split strng #" ")
    (sort weight-comparator)
    (clojure.string/join " ")
    )
  )
