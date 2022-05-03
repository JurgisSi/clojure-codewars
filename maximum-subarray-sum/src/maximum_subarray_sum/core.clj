(ns maximum-subarray-sum.core)

(defn find-max
  [processed value]
  (conj processed (max value (+ value (peek processed))))
  )

(defn max-sequence [xs]
  (apply max (reduce find-max [0] xs))
  )
