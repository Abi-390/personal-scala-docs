package blog

object Traits {

  trait Talker(subject:String) {        // Traits are enhanced with constructor arguments
    def talkTo(another: Talker): String = ""
  }

  class Person(name:String) extends Talker("rock music") {
    override def talkTo(another: Talker): String = ""
  }

  class RockFan extends Talker("rock  music")
  class RockFanatic extends RockFan with Talker     // here we cant pass constructor argument again to talker since we have already passed before

  //derived traits will not pass constructor arguments to parent traits
  trait BrokenRecord extends Talker

  class AnnoyingFriend extends BrokenRecord with Talker("polictics")

  //transparent traits

  transparent trait Paintable     /* since  paintable is transparent so even though it extend with all 3 color in type inference of
                                  val color it will not automatically show paintable also as an intersection type*/

  trait Color extends Paintable  // now color is a child of paintable hence paintable is super+transparent trait now


  case object Red extends Color with Paintable
  case object Blue extends Color with Paintable
  case object Green extends Color with Paintable

  val color = if(43>2) Red else Blue




  def main(args:Array[String]):Unit = {

  }
}
