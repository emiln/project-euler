(ns euler.problem022
  "Problem 22:

  Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
  containing over five-thousand first names, begin by sorting it into
  alphabetical order. Then working out the alphabetical value for each name,
  multiply this value by its alphabetical position in the list to obtain a
  name score.

  For example, when the list is sorted into alphabetical order, COLIN, which
  is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So,
  COLIN would obtain a score of 938 × 53 = 49714.

  What is the total of all the name scores in the file?"
  {:run problem22}
  (:require [clojure.java.io :refer [reader]]
            [clojure.string :refer [split]]))

(defn name-score
  "Score a name by summing the letters with the following rules:
  A = 1, B = 2, C = 3, ..."
  [n]
  (reduce + (map #(- (inc (int %)) (int \A)) n)))

(defn problem22
  []
  (->> (slurp "resources/names.txt")
       (re-seq #"[A-Z]+")
       sort
       (map vector (iterate inc 1))
       (reduce (fn [sum [index name]]
                 (+ sum (* index (name-score name))))
               0)))
