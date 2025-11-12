distance:: String -> String -> Int
distance xs [] = length xs
distance [] ys = length ys
distance (x:xs) (y:ys)
                      | x == y = min (distance xs ys) (min ((distance xs (y:ys)) + 1) ((distance (x:xs) ys) + 1))
                      | otherwise = min ((distance xs ys) + 1) (min ((distance xs (y:ys)) + 1) ((distance (x:xs) ys) + 1))