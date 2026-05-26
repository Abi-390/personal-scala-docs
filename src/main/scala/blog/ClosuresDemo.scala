package blog

object ClosuresDemo {

  def main(array: Array[String]): Unit = {
    /* A simple closure. 'factor' is a free variable (defined outside the anonymous function). 'i' is a bound variable
       (passed directly as a parameter). */
    var factor = 3

    // This anonymous function is a closure because it captures factor.
    val multiplier = (i: Int) => i * factor

    println("--Simple closure---")
    println(s"Multiplying 10  by factor ($factor): " + multiplier(10)) //Output = 30

    /* Dynamic nature of scala closures. If a variable changes outside, the closure sees the updated value. */
    factor = 5
    println(s"Multiplying 10 after changing factor to ($factor):"+multiplier(10))

    // Mutating the free variable inside the closure
    /* Closures  don't just read external variables; they can mutate them too */
    var totalSum = 0;
    val addToStack = (amount: Int) =>{
      totalSum += amount  // mutating the free variable
      println("Current running total sum: "+totalSum)
    }

    println("--> Mutating external state --<")
    addToStack(10)
    addToStack(25)
    addToStack(5)



  }

}
