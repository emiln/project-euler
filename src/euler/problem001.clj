(ns euler.problem001
  "Problem 1:

  If we list all the natural numbers below 10 that are multiples of 3 or 5, we
  get 3, 5, 6 and 9. The sum of these multiples is 23.

  Find the sum of all the multiples of 3 or 5 below 1000."
  {:run problem1})

(defn sum-multiples
  "Returns the sum of i*k for 0 <= i*k < n."
  [n k]
  (let [r (mod n k)
        n' (if (zero? r)
             n
             (+ n (- k r)))]
    (/ (* n' (- n' k))
       (* 2 k))))

(defn problem1 []
  (-> (sum-multiples 1000 3)
      (+ (sum-multiples 1000 5))
      (- (sum-multiples 1000 15))))
