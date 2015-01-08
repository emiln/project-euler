(ns euler.problem019
  "Problem 19:"
  {:run problem19})

;; Mon, Tue, Wed, Thu, Fri, Sat, Sun
;;    1    2    3    4    5    6   7

;; Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec
;;   1    2    3    4    5    6    7    8    9   10   11   12

(defn is-leap?
  "Returns true if year y is a leap year."
  [y]
  (if (zero? (mod y 4))
    (if (zero? (mod y 100))
      (zero? (mod y 400))
      true)
    false))

(defn next-day
  "Returns the next day in the format [weekday day month year]."
  [[day d m y]]
  (let [leap? (is-leap? y)
        days (cond (#{4 6 9 11} m) 30
                   (= 2 m) (if leap? 29 28)
                   :else 31)
        next (inc (mod day 7))]
    (if (= d days)
      (if (= m 12)
        [next 1 1 (inc y)]
        [next 1 (inc m) y])
      [next (inc d) m y])))

(defn problem19
  []
  (->> (iterate next-day [7 1 1 1901])
       (take-while (complement (fn [[day d m y]] (and (= y 2001)
                                                      (= m 1)
                                                      (= d 1)))))
       (filter (fn [[day d & _]] (and (= day 7) (= d 1))))
       count))

