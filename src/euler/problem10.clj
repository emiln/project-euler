(ns euler.problem10
  (:require [euler.algebra :refer [primes-sieve]]))

(->> 2E6
     primes-sieve
     (reduce +')
     println)
