(ns array-diff.core)

(defn array-diff [a b]
  (if (empty? b)
    a
    (recur (filter #(not= (first b) %) a) (rest b))
    )
  )
