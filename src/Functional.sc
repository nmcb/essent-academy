/** sqrt(y)  := { ∃ x | f(x) = x^2 - y = 0 }           */
/** newton's := x[n+1] = x[n] - f(x[n]) / f'(x[n])     */
/** sqrt(y)  := x[n+1] = 0.5 * ( x[n] + y / x[n] )     */
def sqrt(x: Double, delta: Double = 0.000001): Double = {
  def next(prev: Double): Double = 0.5 * (prev + x / prev)
  def loop(c0: Double, e0: Double): Double = {
    val c1 = next(c0)
    val e1 = math.abs(c0 - c1) 
    if (e1 < delta) c1 else loop(c1, e1) 
  }
  loop(math.Pi, Double.MaxValue)
}
