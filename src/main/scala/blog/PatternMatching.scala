package blog

object PatternMatching {

  // A case class to demonstrate constructor matching
  /* case classes automatically support pattern matching deconstruction out of the box */
  case class User(name: String, age: Option[Int], role: String)

  def main(args: Array[String]): Unit = {

    // Simple constant matching -- behaves like standard switch statement
    def matchLiteral(x: Any): String = x match {

      case 1 => "The number one"
      case "Scala" => "The Scala programming language"
      case true => "The boolean value"
      case _ => "Something completely different (default case)"

    }

    println("Literal match: " + matchLiteral("Scala"))
    println("Number match: " + matchLiteral(1))
    println("Boolean match: " + matchLiteral(true))
    println("Default case: " + matchLiteral("default"))

    // Type pattern matching
    /* Replaces ugly 'instanceof' type casting blocks in other languages    */

    def processType(device: Any): String = device match {
      case i: Int => s"Processing an Integer: $i"
      case s: String => s"Processing a String: $s"
      case b: Boolean => s"Processing a boolean: $b"
      case _ => s"Unknown type found"
    }

    println("Processing Int type--> " + processType(1))
    println("Processing String type--> " + processType("Scala"))
    println("Processing Boolean type--> " + processType(false))
    println("Processing default type--> " + processType(34.5))

    // Pattern Guards ( adding if condition inside a case block )
    /* Allows us to add inline  logical filters directly to match our branches  */
    def evaluateNumber(num: Int): String = num match {
      case x if x < 0 => s"$x is a negative number"
      case x if x % 2 == 0 => s"$x is an even number"
      case x if x % 2 != 0 => s"$x is an odd number"
    }

    println("Testing evaluateNumber method for number -1: " + evaluateNumber(-1))
    println("Testing evaluateNumber method for number 2: " + evaluateNumber(2))
    println("Testing evaluateNumber method for number 3: " + evaluateNumber(3))

    // case class deconstruction
    /* This is the peak pattern matching power. It extracts the internal fields of an object instantly */
    val adminUser = User("Abi", Some(23), "Admin")
    val guestUser = User("Bob", Some(29), "Guest")
    val minorUser = User("Shelly", Some(17), "Guest")


    def authorizer(user: User): Unit = user match {
      case User(name, Some(age), "Admin") => println(s"Access granted to Admin: $name(Age:$age)")
      case User(name, Some(age), "Guest") if age < 18 => println(s"Access denied❌, user is below 18 years old.")
      case User(name, Some(age), _) => println(s"Access granted to User: $name(Age:$age)")
      case User(name, None, role) => println(s"Standard access granted with role: $name(role:$role) ")

    }

    authorizer(adminUser)
    authorizer(guestUser)
    authorizer(minorUser)
    authorizer(User("Hena", None, "Guest"))
  }
}

/* Note:  In authorizer always put strict case checking first before other cases for them to check. The stricter the case
  the earlier the case written compared to less strict generalized ones    */