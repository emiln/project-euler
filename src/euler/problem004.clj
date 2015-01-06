(ns euler.problem004
  "Problem 4:

  A palindromic number reads the same both ways. The largest palindrome made
  from the product of two 2-digit numbers is 9009 = 91 × 99.

  Find the largest palindrome made from the product of two 3-digit numbers."
  {:run problem4})

(defn palindrome? [x]
  (let [s (str x)]
    (= (seq s) (reverse s))))

(defn problem4 []
  (->>
   (for [a (range 999 900 -1)]
     (->> (range 999 900 -1)
          (map (partial * a))
          (drop-while (complement palindrome?))
          first))
   (filter identity)
   (reduce max)))
