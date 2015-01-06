(ns euler.problem6
  "Problem 6:

  The sum of the squares of the first ten natural numbers is,
  1^2 + 2^2 + ... + 10^2 = 385

  The square of the sum of the first ten natural numbers is,
  (1 + 2 + ... + 10)^2 = 55^2 = 3025

  Hence the difference between the sum of the squares of the first ten natural
  numbers and the square of the sum is 3025 − 385 = 2640.

  Find the difference between the sum of the squares of the first one hundred
  natural numbers and the square of the sum."
  {:run problem6})

(def nats (range 1 101))

(defn sum-of-squares [ns]
  (reduce + (map #(* % %) ns)))

(defn square-of-sums [ns]
  (let [sum (reduce + ns)]
  	(* sum sum)))

(defn problem6 []
  (->> ((juxt square-of-sums sum-of-squares) nats)
       (apply -)))
