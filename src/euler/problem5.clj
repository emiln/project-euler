(ns euler.problem5
  (:require [euler.algebra :refer [lcm]]))

(->> (range 1 21)
    (reduce lcm)
    println)

