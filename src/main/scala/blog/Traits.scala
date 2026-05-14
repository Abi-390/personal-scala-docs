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


  def main(args:Array[String]):Unit = {

  }
}
