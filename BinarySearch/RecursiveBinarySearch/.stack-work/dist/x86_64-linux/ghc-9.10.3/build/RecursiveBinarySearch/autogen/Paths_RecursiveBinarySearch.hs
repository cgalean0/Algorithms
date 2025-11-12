{-# LANGUAGE CPP #-}
{-# LANGUAGE NoRebindableSyntax #-}
#if __GLASGOW_HASKELL__ >= 810
{-# OPTIONS_GHC -Wno-prepositive-qualified-module #-}
#endif
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
{-# OPTIONS_GHC -w #-}
module Paths_RecursiveBinarySearch (
    version,
    getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where


import qualified Control.Exception as Exception
import qualified Data.List as List
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude


#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [0,1,0,0] []

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir `joinFileName` name)

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath




bindir, libdir, dynlibdir, datadir, libexecdir, sysconfdir :: FilePath
bindir     = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/bin"
libdir     = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/lib/x86_64-linux-ghc-9.10.3-b4c3/RecursiveBinarySearch-0.1.0.0-2FrwO8rLnfdKRq8cCu4l5L-RecursiveBinarySearch"
dynlibdir  = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/lib/x86_64-linux-ghc-9.10.3-b4c3"
datadir    = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/share/x86_64-linux-ghc-9.10.3-b4c3/RecursiveBinarySearch-0.1.0.0"
libexecdir = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/libexec/x86_64-linux-ghc-9.10.3-b4c3/RecursiveBinarySearch-0.1.0.0"
sysconfdir = "/home/nahuel/Documents/university/analisis_y_dise\241o_de_algoritmos/projects/algorithms/BinarySearch/RecursiveBinarySearch/.stack-work/install/x86_64-linux/79c02554a4e83c6e1fd671ba279d2e6a574a3b4de337b8ef14550fc4b5b6010e/9.10.3/etc"

getBinDir     = catchIO (getEnv "RecursiveBinarySearch_bindir")     (\_ -> return bindir)
getLibDir     = catchIO (getEnv "RecursiveBinarySearch_libdir")     (\_ -> return libdir)
getDynLibDir  = catchIO (getEnv "RecursiveBinarySearch_dynlibdir")  (\_ -> return dynlibdir)
getDataDir    = catchIO (getEnv "RecursiveBinarySearch_datadir")    (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "RecursiveBinarySearch_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "RecursiveBinarySearch_sysconfdir") (\_ -> return sysconfdir)



joinFileName :: String -> String -> FilePath
joinFileName ""  fname = fname
joinFileName "." fname = fname
joinFileName dir ""    = dir
joinFileName dir fname
  | isPathSeparator (List.last dir) = dir ++ fname
  | otherwise                       = dir ++ pathSeparator : fname

pathSeparator :: Char
pathSeparator = '/'

isPathSeparator :: Char -> Bool
isPathSeparator c = c == '/'
