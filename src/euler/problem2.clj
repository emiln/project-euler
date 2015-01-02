(ns euler.problem2)

(defn fibonacci
  ([] (fibonacci 1 2))
  ([a b] (cons a (lazy-seq (fibonacci b (+ a b))))))

(take 10 (fibonacci))

(->> (fibonacci)
  (filter even?)
  (take-while (partial > 4000000))
  (reduce +)
  println)
