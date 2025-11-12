recSearch:: [Int] -> Int -> Int
recSearch [] y = -1
recSearch list x = search 0 (length list - 1)
     where
          search lo hi
               | lo > hi = -1
               | otherwise =
                    let mid = lo + (hi - lo) `div` 2
                        midValue = list !! mid
                    in case compare x midValue of
                         EQ -> mid
                         LT -> search lo (mid -1)
                         GT -> search (mid + 1) hi