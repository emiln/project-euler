(ns euler.problem018
  "Problem 18:

  By starting at the top of the triangle below and moving to adjacent numbers on
  the row below, the maximum total from top to bottom is 23.

  3
  7 4
  2 4 6
  8 5 9 3

  That is, 3 + 7 + 4 + 9 = 23.

  Find the maximum total from top to bottom of the triangle below:

  75
  95 64
  17 47 82
  18 35 87 10
  20 04 82 47 65
  19 01 23 75 03 34
  88 02 77 73 07 63 67
  99 65 04 28 06 16 70 92
  41 41 26 56 83 40 80 70 33
  41 48 72 33 47 32 37 16 94 29
  53 71 44 65 25 43 91 52 97 51 14
  70 11 33 28 77 73 17 78 39 68 17 57
  91 71 52 38 17 14 91 43 58 50 27 29 48
  63 66 04 68 89 53 67 30 73 16 69 87 40 31
  04 62 98 27 23 09 70 98 73 93 38 53 60 04 23"
  {:run problem18})

(def triangle
  [[75]
   [95 64]
   [17 47 82]
   [18 35 87 10]
   [20  4 82 47 65]
   [19  1 23 75  3 34]
   [88  2 77 73  7 63 67]
   [99 65  4 28  6 16 70 92]
   [41 41 26 56 83 40 80 70 33]
   [41 48 72 33 47 32 37 16 94 29]
   [53 71 44 65 25 43 91 52 97 51 14]
   [70 11 33 28 77 73 17 78 39 68 17 57]
   [91 71 52 38 17 14 91 43 58 50 27 29 48]
   [63 66  4 68 89 53 67 30 73 16 69 87 40 31]
   [ 4 62 98 27 23  9 70 98 73 93 38 53 60  4 23]])

(defn best-paths
  [row2 row1]
  "Find the best path from row1 to row2. Note that the order of the rows is
  reversed to fit the shape of (reverse triangle). An example:

  Given [a b c d] and [e f g]:
  1. Partition [a b c d] into [[a b] [b c] [c d]].
  2. Call map with the collections [e f g] and [[a b] [b c] [c d]].
  3. Return [(+ e (max a b)) (+ f (max b c)) (+ g (max c d))]

  By reducing the triangle (from the 'biggest' end towards the 'smaller' end),
  the biggest path is calculated."
  (map (fn [a [b c]] (+ a (max b c)))
       row1
       (partition 2 1 row2)))

(defn problem18 []
  (->> triangle
       reverse
       (reduce best-paths)
       first))
