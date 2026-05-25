package blog

import java.io.{File, FileWriter, PrintWriter} // ---> For writing and appending files
import scala.io.Source // ---> allows to open, stream, and read file lines with a single line of code

object FileHandling {

  def main(args: Array[String]): Unit = {
    val fileName = "test_file.txt"


    // Writing to a file
    /* We use java's PrintWriter to override or create a file fresh */
    def writeFile(): Unit = {
      val writer = new PrintWriter(new File(fileName))
      try{
        writer.write("Hello Scala ! \n")
        writer.write("This is line number 2 \n")
        println("File written successfully")
      }
      finally {
        // Always close the file streams in the finally block to prevent memory leaks!
        writer.close()
      }
    }

    // Appending to a file
    /* PrintWriter alone overwrites text. To append, wrap it in a Java FileWriter with 'true' */
    def appendFile(): Unit = {
      val fileWriter = new FileWriter(new File(fileName), true) // --> 'true' enables appending mode
      val printWriter = new PrintWriter(fileWriter)

      try {
        printWriter.write("This line was successfully appended to the bottom . \n")
        println("Text appended successfully")
      }
      finally {
        printWriter.close()
      }
    }

    // Reading from a file ( Native scala way )
    /* We use scala.io.Source which treat file lines like a collection stream */
    def readFile():Unit = {
      println("\n Reading file contents...")
      // Source.fromFile opens the file source
      val fileSource = Source.fromFile(fileName)

      try{
        // getLines() returns an Iterator, making it incredibly memory efficient
        for(line <- fileSource.getLines()){
          println(s">> $line")
        }
      }
      catch{
        case ex:java.io.FileNotFoundException =>
          println("Error: Could not locate file.")
      }
      finally {
        fileSource.close()
      }


    }

    writeFile()
    appendFile()
    readFile()

  }

  /* NOTE : Whenever our application opens a file stream (PrintWriter, FileWriter, or Source.fromFile),
   the operating system locks a file descriptor for our application. If we forget to call .close(),
   that connection stays open in memory. If our program processes thousands of files, it will eventually crash
    with a Too many open files error.Always use finally { stream.close() }.   */

}
