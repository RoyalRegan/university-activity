(princ "Calculating the purchase price")
(terpri)
(princ "Enter base data:")
(terpri)
(princ "Price of one kilogram of apples \(rub\) ") (setq price (read))
(terpri)
(princ "Weight of apple \(kg\) ") (setq weight (read))
(terpri)
(princ "Price for gasoline ") (write (* weight price)) (princ " rubles")
