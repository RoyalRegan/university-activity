#lang racket
(define (custom_sum l)
  (cond
    [(list? l) (cond
                 [(> 7 (length l)) "list size less then 7"]
                 [(and (number? (list-ref l 0))
                       (number? (list-ref l 2))
                       (number? (list-ref l 6))
                  ) (+ (list-ref l 0) (list-ref l 2) (list-ref l 6))]
                 [else (list-ref l (- (length l) 1))]
               )]
    [else "not a list"])
)

(println (custom_sum (list 1 2 3 4 5 6 7)))
(println (custom_sum (list 1 2 3 4 5 6 (list 1 0))))
(println (custom_sum (list 1)))
(println (custom_sum 5))
