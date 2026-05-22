package blog

import java.io.{FileNotFoundException, FileReader, IOException}


object ExceptionHandling {

  def main(args:Array[String]):Unit = {

    // Standard try-catch-finally the pattern matching way
    try {
      println("Attempting to read a non-existant file...")
      val file = new FileReader("missing_logs.txt")
    } catch {
      // catch specific exceptions first just like  pattern matching rules
      case ex:FileNotFoundException => println("Error caught: The file could not be found on tour system.")
      case ex:IOException => println("Error caught: A general I/O system error occurred.")
      case _: Throwable => println("Error caught: An unknown system crash occurred.")
    } finally {
      /* This block always runs , no matter what happens above, ideal for closing db connections or
         freeing up server memory.  */
      println("Finally block : Clean up tasks executed successfully.\n")
    }

    // Internally throwing exception
    /* We throw exceptions using the throw keyword just like other languages.  */
    def validateAge(age:Int):Unit = {
      if(age<0){
        throw new IllegalArgumentException("Age cannot be a negative number")
      } else {
        println(s"Age $age verified successfully")
      }
    }
    try{
      validateAge(-5)
    } catch {
      case ex: IllegalArgumentException => println("Validation failed: "+ex.getMessage)
    }

  }

}

