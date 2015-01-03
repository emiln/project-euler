(set-env!
  :source-paths #{"src"})

(defn run-problem
  "Runs Project Euler problem number n."
  [n]
  (try
    (let [ns (-> "euler.problem"
                 (str n)
                 symbol)]
      (require ns)
      (let [m (-> ns the-ns meta)
            run (intern ns (:run m))]
        (println (:doc m) "\n")
        (println "\n " (time (run)))))
    (catch java.io.FileNotFoundException e
      (println (format "You haven't solved #%d yet." n)))
    (catch Exception e
      (println "Your code failed horribly." "\n")
      (.printStackTrace e))))

(deftask run
  "Runs the code for a given Project Euler problem."
  [n number NUMBER int "The problem's number."]
  (run-problem number)
  identity)
