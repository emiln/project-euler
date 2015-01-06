(ns euler.problem014
  "Problem 14:

  The following iterative sequence is defined for the set of positive integers:

  n → n/2 (n is even)
  n → 3n + 1 (n is odd)

  Using the rule above and starting with 13, we generate the following sequence:
  
  13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

  It can be seen that this sequence (starting at 13 and finishing at 1) contains
  10 terms. Although it has not been proved yet (Collatz Problem), it is thought
  that all starting numbers finish at 1.

  Which starting number, under one million, produces the longest chain?

  NOTE: Once the chain starts the terms are allowed to go above one million."
  {:run problem14})

(defn collatz
  [n]
  (loop [n' n
         c 1]
    (cond (= 1 n') [n c]
          (even? n') (recur (/ n' 2) (inc c))
          :else (recur (inc (* 3 n')) (inc c)))))

(defn problem14 []
  (->> (map collatz (range 500000 1000000))
       (reduce (fn [[n1 c1] [n2 c2]]
                 (if (> c1 c2)
                   [n1 c1]
                   [n2 c2])))
       first))
