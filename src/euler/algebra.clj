(ns euler.algebra
  (:import [java.util BitSet]))

(defn gcd
  "Returns the greatest common divisor of a and b."
  [a b]
  (if (zero? b)
    a
    (recur b (mod a b))))

(defn lcm
  "Returns the least common multime of a and b."
  [a b]
  (/ (* a b) (gcd a b)))

(defn bitset-seq
  "Returns a regular Clojure seq given a java.util.BitSet."
  [^BitSet b]
  (let [length (dec (.length b))]
    (loop [index 2
           primes []]
      (let [next (.nextSetBit b index)]
        (if (< next length)
          (recur (inc next) (conj primes next))
          (conj primes next))))))

(defn primes-sieve
  "Returns all primes less than limit."
  [limit]
  (let [primes (doto (BitSet.)
                 (.set 0 1 false)
                 (.set 2 limit true))
        sqrt (inc (Math/sqrt limit))]
    (doseq [i (range 1 sqrt)]
      (when (.get primes i)
        (doseq [j (range (* i i) limit i)]
          (.clear primes j))))
    (bitset-seq primes)))
