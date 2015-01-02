(ns euler.problem9)

(defn triplet?
  "Returns true if a^2 + b^2 = c^2."
  [[a b c]]
  (= (+ (* a a) (* b b))
     (* c c)))

(defn sums-to-n
  "Returns all vectors [a b c] such that:
  1)   a + c + b = n
  2)   a < b < c"
  [n]
  (for [a (range 1 (/ n 3))
        b (range (inc a) (/ (- n a) 2))]
    [a b (- n a b)]))

(->> (sums-to-n 1000)
     (filter triplet?)
     first
     (reduce *)
     println)

