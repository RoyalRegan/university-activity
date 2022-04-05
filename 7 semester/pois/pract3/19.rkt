#lang racket
(define (map_list 1st)
  (cond
    [(or (not (list? 1st)) (< (length 1st) 2)) "incorrect argument"]
    [(list? (list-ref 1st 0)) (list (list-ref 1st (- (length 1st) 1)) (list-ref 1st 0))]
    [else (remove 2 1st)]
  )
)
(println (map_list (list 1 2 3)))
(println (map_list (list (list 1 2 3) 2 3 4 5 6 7)))
(println (map_list null))
(println (map_list (list 1)))
