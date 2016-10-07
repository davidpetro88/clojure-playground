(ns hangman.core
  (:gen-class))

(def total-live 6)
(def word-secret "CAR")
(defn lose [] (print "You Lose"))
(defn win [] (print "You Win"))

(defn letter-missing [word correct]
  (remove (fn [letra] (contains? correct (str letra))) word))

(defn is-every-word [word correct]
  (empty? (letter-missing word correct)))

(defn read-letter! [] (read-line))

(defn is-correct? [kick word] (.contains word kick))

;doseq função preguiçosa, a qual não é executada até ser pedido seu resultado.
(defn print-hangman [lives word correct]
  (println "Lives " lives)
  (doseq [letter (seq word)]
    (if (contains? correct (str letter))
      (print letter " ") (print "_" " ")))
  (println))

(defn play [live word correct]
  (print-hangman live word correct)
  (cond
    (= live 0) (lose)
    (is-every-word word correct) (win)
    :else
    (let [kick (read-letter!)]
      (if (is-correct? kick word)
        (do
          (println "You're right!")
          (recur live word (conj correct kick)))
        (do
          (println "Error the letter! You Lose Live!")
          (recur (dec live) word correct))))))

(defn evaluates-kick [kick lives word correct]
  (if (is-correct? kick word)
    (play lives word (conj correct kick))
    (play (dec lives) word correct)))

(defn start-game [] (play total-live word-secret #{}))

(defn -main  [& args] (start-game))