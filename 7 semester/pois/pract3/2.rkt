#lang racket
(define (custom_sqrt x)
  (cond
    [(number? x)(sqrt x)]
    [(list? x)(list-ref x (- (length x) 1))]
    [else x])
    
)

(println (custom_sqrt 25))
(println (custom_sqrt (list 1 2 3 4 100)))
(println (custom_sqrt "not list"))
