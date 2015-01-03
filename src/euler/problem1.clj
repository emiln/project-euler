(ns euler.problem1)

(defn sum-multiples
  "Returns the sum of i*k for 0 <= i*k < n."
  [n k]
  (let [r (mod n k)
        n' (if (zero? r)
             n
             (+ n (- k r)))]
    (/ (* n' (- n' k))
       (* 2 k))))

(-> (sum-multiples 1000 3)
    (+ (sum-multiples 1000 5))
    (- (sum-multiples 1000 15))
    println)
