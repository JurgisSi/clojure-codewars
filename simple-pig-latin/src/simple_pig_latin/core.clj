(ns simple-pig-latin.core)

(defn piggify [w]
  (if (and (= (count w) 1) (not (Character/isLetter ^Character (.charAt w 0))))
    w
    (let [word (clojure.string/split w #"")]
      (str (clojure.string/join (rest word)) (first word) "ay")))
  )

(defn pig-it [s]
  (clojure.string/join " " (map #(piggify %) (clojure.string/split s #" ")))
  )
