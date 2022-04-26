(ns playing-with-passphrases.core)

(defn rot [character level]
  (Character/toString (char (+ (mod (- (+ (int (first (char-array character))) level) 65) 26) 65)))
  )

(defn complement-to-9 [number]
  (Integer/toString (- 9 (Integer/parseInt number)))
  )

(defn encode-char [character level]
  (let [char (first (char-array character))]
    (if (Character/isLetter char)
      (rot character level)
      (if (Character/isDigit char)
        (complement-to-9 character)
        character
        )
      ))
  )

(defn encode
  ([phrase level] (encode '[] level (clojure.string/split phrase #"")))
  ([encoded level other]
   (if (empty? other)
     encoded
     (recur (conj encoded (encode-char (first other) level)) level (rest other))
     )
   )
  )

(defn update-case [letter index]
  (if (even? index)
    (clojure.string/lower-case letter)
    letter
    )
  )

(defn sponge-bob-case
  ([phrase] (sponge-bob-case '[] phrase 1))
  ([changed phrase index]
   (if (empty? phrase)
     changed
     (recur (conj changed (update-case (first phrase) index)) (rest phrase) (inc index))
     )
   )
  )

(defn play-pass [s n]
  (clojure.string/join (reverse (sponge-bob-case (encode (clojure.string/upper-case s) n))))
  )
