(ns euler.problem020
  "Problem 20:"
  {:run problem20}
  (:require [euler.algebra :refer [factorial]]))

(defn problem20 []
  (->> (factorial 100)
       str
       (map #(Character/getNumericValue %))
       (reduce +)))
