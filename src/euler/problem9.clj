(ns euler.problem9
  "Problem 9:

  A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
  a^2 + b^2 = c^2

  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc."
  {:run problem9})

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

(defn problem9 []
  (->> (sums-to-n 1000)
       (filter triplet?)
       first
       (reduce *)))

