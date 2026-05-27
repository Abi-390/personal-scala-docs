package blog


object doubtSolvingSheet {
  def main(arg: Array[String]): Unit = {


    /* case class User( id:Int, name:String)

    val user0 = User(1,"Abi")

    def checkUser(id:Int):Unit = id match {
      case id if id<0 => println("")
    }

    checkUser(user0.id)
  }*/

    val List1: Option[List[Int]] = Some(List(1, 2, 3, 4, 5))


    val B = List1.flatMap(x => x.headOption)
    println(B)

    val A = List1.toList
    println(A)
    val ListFlat = A.flatMap(x => x.toList)
    println(ListFlat)

    ListFlat match {
      case lis if lis.contains(0) == false => println("0 notFound:" + lis)
      case list if list.contains(1) => println("1 found" + list)
      case _ => println("No match")
    }


    case class UserDetails(id: Int, name: String)

    def authenticateUser(userDetails: UserDetails): Unit = userDetails match {
      case UserDetails(id, name) if id < 0 => println("User id is invalid -->" + id)
      case UserDetails(_, name) if name.trim.isEmpty => println("Name cannot be empty")
      case UserDetails(id, name) => println(s"Welcome $name, your  id is $id")
    }

    authenticateUser(UserDetails(-1, "Abinash"))
    authenticateUser(UserDetails(1, " "))
    authenticateUser(UserDetails(1, "Abinash"))


    def longestSubString(s: String): Unit = {

      var left = 0
      var right = 0
      var maxLen = 0
      var seen = Set[Char]()

      while (s.length > right) {
        val currentChar = s(right)

        while (seen.contains(currentChar)) {
          seen = seen - s(left)
          left = left + 1
        }
        seen = seen + currentChar
        maxLen = Math.max(maxLen, right - left + 1)
        right = right + 1
      }
      println("Longest substring length is: " + maxLen)

    }

    longestSubString("abcxdbcdefgxdgbc")


  }
  


  val input = scala.io.StdIn.readLine("Type 'START' for your program to run ")
  if (input == "START")
    println("Granted access to for this code to run.")
  else {
    throw new IllegalArgumentException("Invalid input, try again.")
  }



}
