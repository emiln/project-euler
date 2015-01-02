(ns euler.problem7
  (:require [euler.algebra :refer [primes-sieve]]))

(let [n 10001
      limit (* 20 n)
      primes (primes-sieve limit)]
  (println (nth primes n)))
