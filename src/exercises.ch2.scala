/** Functional Programming in Scala - Chapter 2 */


/** Exercise 1: Write a function to compute the nth fibonacci number */
def fib(n: Int): Int = ???

/** Exercise 2: Implement a polymorphic function returning whether an `Array[A]` is sorted */
def isSorted[A](as: Array[A], gt: (A, A) => Boolean): Boolean = ???

/** Exercise 3: Implement `curry`. */
// Note that `=>` associates to the right, so we could write the return type as `A => B => C`
def curry[A, B, C](f: (A, B) => C): A => (B => C) = ???

/** Exercise 4: Implement `uncurry` */
def uncurry[A, B, C](f: A => B => C): (A, B) => C = ???

/** Exercise 5: Implement `compose` */
def compose[A, B, C](f: B => C, g: A => B): A => C = ???