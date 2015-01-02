(ns euler.problem4)

(defn palindrome? [x]
  (let [s (str x)]
    (= (seq s) (reverse s))))

(->>
  (for [a (range 999 900 -1)]
    (->> (range 999 900 -1)
      (map (partial * a))
      (drop-while (complement palindrome?))
      first))
  (filter identity)
  (reduce max)
  println)