# Programming Paradigms

## Scala Worksheet Supplemental - Three: Functional constructs

This sheet is intended to familiarise students with the functional programming aspects of the Scala programming language.

1. Write the following *anonymous functions* in Scala:  
    + A function that takes a `Boolean` and returns it.
    + A function that takes an `Int` argument `x` and returns a function that takes no arguments which returns `x`.
    + A function that takes two arguments, an `Int n` and a function `f` from `Int` to `Int`, and applies `f` to `n`.
    + The curried version of the previous function.
    + A function that takes an `Int n` and two functions `f` and `g` from `Int` to `Int` and applies `f` to the result of 
    `g` applied to `n`.
    + The curried version of the previous function.
2. Write Scala code to do the following:
    + Write an expression that creates a `List` containing the integers `1` through `5`, in order.
    + Write an expression that reverses the `List` for a `List` containing the integers `1` through `5`, in order.
    + Write an expression that returns a new `List` given by negating every element of a `List`
        containing the integers `1` through `5`, in order.  
        **Hint**: pass a function to the `List.map` method.
    + Write an expression which sums the elements of the `List` containing the integers `1` through `5`, in reverse order.  
        **Hint**: Consider using `List.foldLeft`.   
        **Hint**: There is a better hint!
3. The familiar *Fibonacci sequence* `F(n)` is given by the inductive definition:
    ```
    F(0)=1
    F(1)=1
    F(n) = F(n−2)+F(n−1)
    ```
    This definition leads immediately to a straightforward algorithm for computing `F(n)`. 
    This algorithm can be implemented in Scala as follows:
    ```scala
      def fib(n: Int): Int = if (n <= 1) 1 else fib(n-1) + fib(n-2)
    ```
    While simple, the algorithm runs in *exponential time*. 
    A linear algorithm takes advantage of the fact that `fib(n-1)` calls `fib(n-2)`, 
    and reuses the result when computing `fib(n)`.
    + Write a recursive Scala function with the following signature:
        ```scala
        def fib2(n: Int): (Int, Int)
        ```
        that computes both `fib(n)` and `fib(n-1)` in linear time. The function should evaluate as follows:  
        ```scala
        fib2(0) = (1,1)
        fib2(1) = (1,1)
        fib2(2) = (2,1)
        fib2(3) = (3,2)
        fib2(4) = (5,3)
        ...
        The `fib` function can then be implemented efficiently using `fib2` 
        and selecting the first element of the pair returned:
        ```scala
        def fib(n: Int) = fib2(n)._1
        ```
    + Try running `fib(100000)` in the Scala interpreter. What happens? 
    + Is the function `fib2` you wrote tail recursive?  
        Explain why or why not. 
    + If not already tail recursive, write a new version of the function `fib2`, called `fib3`, 
        that is *tail recursive*. `fib3` might possibly require a different signature than `fib2`
        (i.e., it might have more *formal parameters*). 
    + Implement `fib` using `fib3`.
