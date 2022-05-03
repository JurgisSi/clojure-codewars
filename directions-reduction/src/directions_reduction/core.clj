(ns directions-reduction.core)

(def opposites (hash-map
                 "NORTH" "SOUTH"
                 "SOUTH" "NORTH"
                 "EAST" "WEST"
                 "WEST" "EAST"))

(defn simplify
  [arr direction]
  (if (= (peek arr) (get opposites direction))
    (pop arr)
    (conj arr direction)
    )
  )

(defn dirReduc
  [arr]
  (not-empty (reduce simplify [] arr))
  )
