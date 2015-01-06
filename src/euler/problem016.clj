(ns euler.problem016
  "Problem 16:

  2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.

  What is the sum of the digits of the number 2^1000?"
  {:run problem16}
  (:import [java.math BigInteger]))

(defn count-digits [big]
  (reduce + (map #(Character/getNumericValue %) (str big))))

(defn problem16 []
  (->> 1000
       (.pow (BigInteger. "2"))
       count-digits))
