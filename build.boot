(set-env!
  :source-paths #{"src"})

(defn run-problem
  "Runs Project Euler problem number n."
  [n]
  (let [code (symbol (str "euler.problem" n))]
    (println (str "Result of (use '" code "):"))
    (try
      (use code)
      (catch java.io.FileNotFoundException e
        (println (str "Couldn't find the file for problem " n "."))))))

(deftask run
  "Runs the code for a given Project Euler problem."
  [n number NUMBER int "The problem's number."]
  (time (run-problem number))
  identity)