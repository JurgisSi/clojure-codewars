(ns human-readable-time.core)

(def seconds-in-hour 3600)
(def seconds-in-minute 60)

(defn human-readable
  [seconds]
  (let [hours (quot seconds seconds-in-hour)
        minutes (quot (mod seconds seconds-in-hour) seconds-in-minute)
        seconds (mod seconds seconds-in-minute)]
    (format "%02d:%02d:%02d" hours minutes seconds)
    )
  )
