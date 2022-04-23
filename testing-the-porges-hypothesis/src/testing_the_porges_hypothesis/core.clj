(ns testing-the-porges-hypothesis.core)

(defn split-into-digits [x]
  (map #(Character/digit % 10) (str x))
  )

(defn sum-digit-squares [x]
  (reduce + (map #(* % %) (split-into-digits x)))
  )

(defn porges-cycle
  ([x] (porges-cycle x #{x}))
  ([x used]
   (let [square (sum-digit-squares x)]
     (if (= 1 square)
       -1
       (if (contains? used square)
         square
         (recur square (conj used square))
         ))
     )
   )
  )
