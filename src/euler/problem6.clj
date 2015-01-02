(ns euler.problem6)

(def nats (range 1 101))

(defn sum-of-squares [ns]
  (reduce + (map #(* % %) ns)))

(defn square-of-sums [ns]
  (let [sum (reduce + ns)]
  	(* sum sum)))

(->> ((juxt square-of-sums sum-of-squares) nats)
     (apply -)
     println)
