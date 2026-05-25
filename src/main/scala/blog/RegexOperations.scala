package blog

import scala.util.matching.Regex

object RegexOperations {

  def main(args: Array[String]): Unit = {

    // Creating a regular expression (.r extension)
    /* Adding '.r' to a string converts  it into  a scala.util.matching.Regex object. We use triple quotes(""") to avoid
       having to double -space backslashes like \\d */

    val numericPattern: Regex = """\d+""".r // Matches one or more consecutive digits

    // Finding matches inside text
    val sampleText = "The server log code is 404 and response time  is 125ms ."

    // findFirstIn returns  an Option[String] --> Some if found, None if missing
    val firstMatch: Option[String] = numericPattern.findFirstIn(sampleText)
    println("First number found: "+ firstMatch.getOrElse("No digits found"))

    // findAllIn returns an Iterator[String] containing all occurrences
    val allMatches:Iterator[String] = numericPattern.findAllIn(sampleText)
    println("All numbers found: "+allMatches.toList)  // Forced evaluation to List

    // Modifying strings using regex replacement
    val maskedText: String = numericPattern.replaceAllIn(sampleText,"[REDACTED]")
    println("Masked string output: "+maskedText)

    // Extracting fields using pattern matching and groups
    /* Putting variables in parentheses () creates matching subgroups */
    val contactPattern: Regex = """([A-Za-z]+)-(\d+)""".r // Format -> Name-ID ( eg: "Abi-390" )

    val employeeRecord = "Processing record for worker: Abi-390"

    //findFirstMatchIn extracts the match data object safely
    contactPattern.findFirstMatchIn(employeeRecord) match {
      case Some(matchObj) =>
        val workerName = matchObj.group(1)
        val workerId = matchObj.group(2)
        println(s"Extracted via Groups --> Name: $workerName, ID: $workerId")
      case None =>
        println("No employee record matches the pattern.")
    }

    // Inline extraction directly inside case statements
    /* Scala lets us use our regex object directly as a Case pattern constructor  */
    val identityBadge = "Abi-390"

    identityBadge match {
      case contactPattern(name,id) =>
        println(s"Inline match success! Verified name with $name and id with #$id.")
      case _ =>
        println("Invalid badge format string layout.")
    }


  }

}
