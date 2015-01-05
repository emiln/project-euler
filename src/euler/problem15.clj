(ns euler.problem15
  "Problem 15:

  Starting in the top left corner of a 2x2 grid, and only being able to move to
  the right and down, there are exactly 6 routes to the bottom right corner.

  How many such routes are there through a 20x20 grid?"
  {:run problem15})

;; This is equivalent to the binomial of (40, 20), the intuition being that
;; there are 40 steps in total, and you pick 20 of them as being vertical. The
;; solution to this problem is thus the same as the number of ways to pick 20 
;; steps out of 40.

;; The specific binomial implementation here is the product from i=1 to k of
;; (n + 1 - i)/i.

(defn binomial
  "Returns the binomial of (n k); the number of ways to take k elements from n."
  [n k]
  (->> (range 1 (inc k))
       (map (fn [i] (/ (inc (- n i)) i)))
       (reduce *')))

(defn problem15 []
  (binomial 40 20))
