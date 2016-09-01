/** Functional Programming in Scala - Chapter 2 */

/** Exercise 1: Write a function to compute the nth fibonacci number */
def fib(n: Int): Int = ???

/** Exercise 2: Implement a polymorphic function returning whether an `Seq[A]` is sorted */
def isSorted[A](as: Seq[A], gt: (A, A) => Boolean): Boolean = ???

/** Exercise 3: Implement `curry`. */
def curry[A,B,C](f: (A, B) => C): A => B => C = ???

/** Exercise 4: Implement `uncurry` */
def uncurry[A,B,C](f: A => B => C): (A, B) => C = ???

/** Exercise 5: Implement `compose` */
def compose[A, B, C](f: B => C, g: A => B): A => C = ???


// FUN

def fibs(n: Int): Seq[Int] = Seq.tabulate(n)(fib)
assert(fibs(7) == Seq(0,1,1,2,3,5,8))

def gt(x: Int, y: Int) = x > y
assert(isSorted(Seq(5,4,3,2,1), gt) == true)
assert(isSorted(Seq(5,1,3,2,4), gt) == false)

assert(gt(1,0) == true)
def cgt = curry(gt)
assert(cgt(1)(0) == true)
def ogt = uncurry(cgt)
assert(ogt(1,0) == true)

def twice(x: Int)  = x + x
def square(x: Int) = x * x
def twicesquared = compose(twice, square)
assert(twicesquared(3) == 18)


// ANSWERS

// /** Exercise 1: Write a function to compute the nth fibonacci number */
// def fib(n: Int): Int = {
//   @annotation.tailrec
//   def go(i: Int, next: Int = 1, prev: Int = 0): Int = i match {
//     case 0 => prev
//     case _ => go(i - 1, next + prev, next)
//   }
//   go(n)
// }

// /** Exercise 2: Implement a polymorphic function returning whether an `Seq[A]` is sorted */
// def isSorted[A](as: Seq[A], gt: (A, A) => Boolean): Boolean = {
//   if (as.length == 0 || as.length == 1) true
//   else gt(as(0), as(1)) && isSorted(as.tail, gt)
// }

// /** Exercise 3: Implement `curry`. */
// def curry[A,B,C](f: (A, B) => C): A => B => C = a => b => f(a,b)

// /** Exercise 4: Implement `uncurry` */
// def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a: A, b: B) => f(a)(b)

// /** Exercise 5: Implement `compose` */
// def compose[A, B, C](f: B => C, g: A => B): A => C = a => f(g(a))
