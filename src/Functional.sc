/** sqrt(y)  := { ∃ x | f(x) = x^2 - y = 0 }           */
/** newton's := x[n+1] = x[n] - f(x[n]) / f'(x[n])     */
/** sqrt(y)  := x[n+1] = 0.5 * ( x[n] + y / x[n] )     */

def sqrt(x: Double, delta: Double = 4.9E-324): Double = {
  type Num = BigDecimal
  val  Num = BigDecimal
  def next(prev: Num): Num = 0.5 * (prev + x / prev)
  def loop(c0: Num, e0: Num): Num = {
    val c1 = next(c0)
    val e1 = (c0 - c1).abs 
    if (e1 < delta) c1 else loop(c1, e1) 
  }
  loop(Num(math.Pi), Num(Double.MaxValue)).toDouble
}  


import $ivy.`org.scalacheck::scalacheck:1.13.2`
import org.scalacheck.Properties
import org.scalacheck.Prop.forAll


// private static final BigDecimal SQRT_DIG = new BigDecimal(150);
// private static final BigDecimal SQRT_PRE = new BigDecimal(10).pow(SQRT_DIG.intValue());
//
// /**
//  * Private utility method used to compute the square root of a BigDecimal.
//  * 
//  * @author Luciano Culacciatti 
//  * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
//  */
// private static BigDecimal sqrtNewtonRaphson  (BigDecimal c, BigDecimal xn, BigDecimal precision){
//     BigDecimal fx = xn.pow(2).add(c.negate());
//     BigDecimal fpx = xn.multiply(new BigDecimal(2));
//     BigDecimal xn1 = fx.divide(fpx,2*SQRT_DIG.intValue(),RoundingMode.HALF_DOWN);
//     xn1 = xn.add(xn1.negate());
//     BigDecimal currentSquare = xn1.pow(2);
//     BigDecimal currentPrecision = currentSquare.subtract(c);
//     currentPrecision = currentPrecision.abs();
//     if (currentPrecision.compareTo(precision) <= -1){
//         return xn1;
//     }
//     return sqrtNewtonRaphson(c, xn1, precision);
// }
//
// /**
//  * Uses Newton Raphson to compute the square root of a BigDecimal.
//  * 
//  * @author Luciano Culacciatti 
//  * @url http://www.codeproject.com/Tips/257031/Implementing-SqrtRoot-in-BigDecimal
//  */
// public static BigDecimal bigSqrt(BigDecimal c){
//     return sqrtNewtonRaphson(c,new BigDecimal(1),new BigDecimal(1).divide(SQRT_PRE));
// }
//
// --http://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java
