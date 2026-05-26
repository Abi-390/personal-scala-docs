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
      case list if ListFlat.contains(1) => println("1 found")
      case _ => println("No match")
    }


    case class UserDetails(id: Int, name: String)

    def authenticateUser(userDetails: UserDetails): Unit = userDetails match {
      case UserDetails(id,name) if id<0 => println("User id is invalid -->" +id)
      case UserDetails(_,name) if name.trim.isEmpty => println("Name cannot be empty")
      case UserDetails(id,name) => println(s"Welcome $name, your  id is $id")
    }

    authenticateUser(UserDetails(-1, "Abinash"))
    authenticateUser(UserDetails(1, " "))
    authenticateUser(UserDetails(1, "Abinash"))



  }
}
