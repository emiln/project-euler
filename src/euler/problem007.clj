(ns euler.problem7
  "Problem 7:

  By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
  that the 6th prime is 13.

  What is the 10 001st prime number?"
  {:run problem7}
  (:require [euler.algebra :refer [primes-sieve]]))


(defn problem7 []
  (let [n 10001
        limit (* 20 n)
        primes (primes-sieve limit)]
    (nth primes n)))
