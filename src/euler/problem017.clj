(ns euler.problem017
  "Problem 17:

  If the numbers 1 to 5 are written out in words: one, two, three, four, five,
  then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.

  If all the numbers from 1 to 1000 (one thousand) inclusive were written out in
  words, how many letters would be used?

  NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
  forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20
  letters. The use of and when writing out numbers is in compliance with British
  usage."
  {:run problem17})

(defn num->str [n]
  "Converts n to a spaceless string like 'twohundredandeightynine'."
  (cond (< n 20) ({1 "one" 2 "two" 3 "three" 4 "four"
                   5 "five" 6 "six" 7 "seven"
                   8 "eight" 9 "nine" 10 "ten"
                   11 "eleven" 12 "twelve" 13 "thirteen"
                   14 "fourteen" 15 "fifteen" 16 "sixteen"
                   17 "seventeen" 18 "eighteen" 19 "nineteen"} n)
        (and (= 0 (mod n 10))
             (< n 100)) ({20 "twenty" 30 "thirty" 40 "forty"
                          50 "fifty" 60 "sixty" 70 "seventy"
                          80 "eighty" 90 "ninety"} n)
        (< n 100) (str (num->str (* 10 (quot n 10)))
                       (num->str (mod n 10)))
        (and (= 0 (mod n 100))
             (< n 1000)) (str (num->str (quot n 100)) "hundred")
        (< n 1000) (str (num->str (* 100 (quot n 100)))
                        "and"
                        (num->str (mod n 100)))
        (= n 1000) "onethousand"))

(defn problem17 []
  (->> (range 1 1001)
       (map num->str)
       (reduce #(+ %1 (count %2)) 0)))
