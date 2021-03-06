(ns euler.problem045
  "Problem 45:

  Triangle, pentagonal, and hexagonal numbers are generated by the following
  formulae:
  Triangle 	  	Tn=n(n+1)/2 	  	1, 3, 6, 10, 15, ...
  Pentagonal 	  	Pn=n(3n-1)/2 	  	1, 5, 12, 22, 35, ...
  Hexagonal 	  	Hn=n(2n-1) 	  	1, 6, 15, 28, 45, ...

  It can be verified that T285 = P165 = H143 = 40755.

  Find the next triangle number that is also pentagonal and hexagonal."
  {:run problem45})

(def nats (iterate inc 1))

(def pentags
  (map #(/ (* % (dec (* 3 %))) 2) nats))

(def hexags
  (map #(* % (dec (* 2 %))) nats))

;; Seeing how all hexagonal numbers are also triangle numbers, it's rather
;; pointless to actually check the triangle numbers.

(defn problem45 []
  (loop [p (drop-while (partial > 40756) pentags)
         h (drop-while (partial > 40756) hexags)]
    (let [p' (first p)
          h' (first h)]
      (cond (= p' h') p'
            (> p' h') (recur p (rest h))
            :else (recur (rest p) h)))))
