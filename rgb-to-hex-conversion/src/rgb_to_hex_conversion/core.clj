(ns rgb-to-hex-conversion.core
  (:require clojure.string))

(defn normalize [number]
  (if (< (count number) 2)
    (str "0" number)
    number
    )
  )

(defn to-hex [number]
  (clojure.string/upper-case (normalize (Integer/toString number 16)))
  )

(defn limit [number]
  (if (> number 255)
    255
    (if (< number 0)
      0
      number))
  )

(defn rgb [r g b]
  (str (to-hex (limit r)) (to-hex (limit g)) (to-hex (limit b))))