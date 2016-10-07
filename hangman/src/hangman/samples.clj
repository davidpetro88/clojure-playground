(ns hangman.samples)

(defn example-map []
  (println "Use the map function to multiply all the numbers in the numbers list for 3.")
  (def nums [1 2 3 4 5])
  (map (fn[integer-number] *  integer-number 3) nums))

  (defn example-filter []
  (println "smaller numbers than 2 greater than 4.")
  (def nums [1 2 3 4 5])
  (filter (fn [x] (or (< x 2) (> x 4))) nums))

(defn example-map-2 []
  (println "multiply 2.")
  (def cars [50000.0, 60000.0])
  (map (fn[x] (* x 2)) cars))

(defn example-map-3 []
  (println "multiply 2.")
  (def cars [50000.0, 60000.0])
  (->> cars
       (map (fn[x] (* x 2.0)))))

(defn example-map-4 []
  (println "multiply 2 and decrease by 200.")
  (def cars [50000.0, 60000.0])
  (map (fn[x] (- x 200.0))  (map (fn[x] (* x 2.0)) cars)))

(defn example-map-5 []
  (println "multiply 2 and decrease by 200.")
  (def cars [50000.0, 60000.0])
  (->> cars
     (map (fn[x] (* x 2.0)))
     (map (fn[x] (- x 200.0)))))


