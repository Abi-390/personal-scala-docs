package blog

object OpaqueTypes {

  object SocialNetwork {
    opaque type Name = String
    //Name == String --> Name is a type of type string that's initial is a capital letter

    // 1- companion object
    object Name {
      def fromString(s:String):Option[Name]=
        if(s.isEmpty || s.charAt(0).isLower) None else Some(s)
    }

    // 2- extension method
    extension (n:Name){
      def length:Int = n.length // on the  String class
    }

  }

  import SocialNetwork._

  // Outside  of the scope, Name != String
  // val name: Name = "Abi" --> will not compile

  object Graphics {
    opaque type Color = Int  // in hex
    opaque type ColorFilter <: Color = Int // Subtype of color type with a type int

    val Red:Color = 0xFF000000
    val Green:Color = 0x00FF0000
    val Blue:Color = 0x0000FF00
    val halfTransparency: ColorFilter = 0x88

  }

  import Graphics ._
  case class OverlayFilter(c:Color)
  val fadeLayer = OverlayFilter(halfTransparency)




  def main(args:Array[String]):Unit = {

    val nameOption = Name.fromString("Abi") // Some("Abi")
    nameOption.foreach(println)

    val abiNameLengthOption = nameOption.map(_.length)
    abiNameLengthOption.foreach(println)

  }

}
