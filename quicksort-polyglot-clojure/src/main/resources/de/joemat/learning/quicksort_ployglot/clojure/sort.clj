(ns de.joemat.learning.quicksort_polyglot.clojure)

(comment
   inspired by https://stackoverflow.com/questions/6815929/naive-quick-sort-in-clojure
)

(defn quicksort-impl [unsorted]
   (cond
      (empty? unsorted) '()
      :else (let [pivot (first unsorted)
                  remaining (rest unsorted)
                  lower (filter #(<= % pivot) remaining)
                  greater (filter #(> % pivot) remaining)]
              (concat (quicksort-impl lower) [pivot] (quicksort-impl greater)))))

(defn quicksort [unsorted callback]
    (let [sorted (quicksort-impl unsorted)]
        (.accept callback sorted)
        sorted))
