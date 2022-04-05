(princ "Calculating the area of a ring")
(terpri)
(princ "Enter base data:")
(terpri)
(princ "Ring radius ") (setq ring_r (read))
(terpri)
(princ "Hole radius ") (setq hole_r (read))
(terpri)
(if (or (> 1 ring_r) (> 1 hole_r)) (progn (princ "Incorrect radius") (exit)))
(if (> ring_r hole_r) (princ (* pi (- (expt ring_r 2) (expt hole_r 2)))) (princ "Error! Hole radius cannot be equal to or greater than ring radius"))
