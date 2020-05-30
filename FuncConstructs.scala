package Functional

object FuncConstructs extends  App{
  def takeBoolAndRet(bool: Boolean) : Boolean = bool
  def takeInt(x: Int): () => Int = () =>  x
  def takeTwo(n: Int, f: Int => Int  ) : Int = f(n)
  def takeTwoCurried(n: Int, f: Int => Int  ) = () => f(n)

  def takesTwoFuncs(a: Int, b: Int  , f: Int => Int ,g: (Int, Int) => Int ): Int = f(g(a,b))
  def takesTwoFuncsCurried(a: Int, b: Int,  f: Int => Int ,g: (Int, Int) => Int  ):() => Int = () => f(g(a , b))

  def square(i: Int): Int = i * i
  def sub(a: Int , b: Int): Int = a - b
   println(takeInt(10)())
  println(takeTwo(2, square))
   println(takeTwoCurried(2,  square)())
  println(takesTwoFuncs(1, -5,   Math.abs, sub))
  println(takesTwoFuncsCurried(1, -5,   Math.abs, sub)())

  println(List.range(1,6))
  println(List.range(1,6).reverse)
  println(List.range(1,6).map(x => -x))
  println(List.range(1,6).reduce((total, cur)=> total + cur))
  println(List.range(1,6).foldLeft(0)(_+_))

  def fib0(n: Int): Int = if (n <= 1) 1 else fib(n-1) + fib(n-2)

  def fib2(n: Int): (Int, Int) = { if (n <= 1) (1,1) else ( fib2(n-1)._1 + fib2(n-1)._2, fib2(n-1)._1 )}
  def fib(n: Int) = fib2(n)._1
  println(fib(4))
  def fib3(n: Int,  next: Int, prev: Int): (Int, Int)= {

    if (n <= 1) (next, prev)
      else
    ( fib3(n-1,    next+prev, next ) )
  }
  def fibacc(n: Int, next: Int, prev: Int) = fib3(n, next, prev )._1
  println(fibacc(4, 1,1))




}
