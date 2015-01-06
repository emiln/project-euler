(ns euler.problem003
  "Problem 3:

  The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143?"
  {:run problem3}
  (:require [euler.algebra :refer [gcd]]))

(defn mod-power [x k n]
  (reduce #(mod (* %1 %2) n) (repeat k x)))

(defn pollard-power [smoothness n]
  (let [powers (iterate (fn [[a p]] [(mod-power a p n) (inc p)])
                        [2 2])]
    (first (drop (dec smoothness) powers))))

(defn smoothness-of [n]
  10)

(defn pollard-p
  ([n b]
   (let [p (first (pollard-power b n))
         d (gcd (dec p) n)]
     (if (< 1 d n)
       d
       (if (< (* b b) n)
         (recur n (* b 2))
         nil))))
  ([n] (pollard-p n 10)))

(defn prime-factors [n]
  (if-let [fac (pollard-p n)]
    (concat (prime-factors fac) (prime-factors (/ n fac)))
    [n]))

(defn problem3 []
  (->> 600851475143N
       prime-factors
       (apply max)
       int))
