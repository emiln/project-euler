(ns euler.problem1)

(->> (concat (range 0 1000 3) (range 0 1000 5))
  (apply hash-set)
  (reduce +)
  println)
