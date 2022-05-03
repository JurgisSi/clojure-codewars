(ns directions-reduction.core)

(def opposites (hash-map
                 "NORTH" "SOUTH"
                 "SOUTH" "NORTH"
                 "EAST" "WEST"
                 "WEST" "EAST"))

(defn reduce-directions
  ([directions one]
   (conj directions one))
  ([directions one two]
   (if (= (get opposites one) two)
     (not-empty directions)
     (conj directions one two))
   )
  ([directions one two & other]
   (if (= (get opposites one) two)
     (if (empty? directions)
       (apply reduce-directions directions other)
       (apply reduce-directions (pop directions) (peek directions) other)
       )
     (apply reduce-directions (conj directions one) two other))
   )
  )

(defn dirReduc
  [arr]
  (if (empty? arr)
    nil
    (apply reduce-directions [] arr))
  )
