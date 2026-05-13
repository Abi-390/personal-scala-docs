package blog

import java.io.File

object NewTypes {

  //1 -literal types
  val aNumber = 3  // compiler auto-detected type as int from RHS
  val three: 3 =3 // 3 became a subtype of int

  def passNumber(n:Int)=println(n)
  passNumber(45)
  passNumber(three) //ok

  def passStrict(n:3)=println(n)
  passStrict(three) //ok
  passStrict(3)  //ok
 // passStrict(45) --> not ok
 // passStrict(five) --> not ok

  val pi: 3.14 = 3.14
  val truth:true = true
  val myFavLang:"Scala" = "Scala"

  def doSomethingWithYourLife(meaning: Option[42]): Unit = meaning.foreach(println) // type either 42 or none

  // 2 - Union types
  def ambivalentMethod(arg: Int | String): Unit = arg match {
    case _: String => println(s"A String : $arg")
    case _: Int => println(s"An Int : $arg")
  }
    ambivalentMethod(42) // ok
    ambivalentMethod("Scala") //ok

    type Error[T] = T | "error"

    def handleError(file: Error[File]):Unit ={
      // code
      ()
    }

   // val stringOrInt = if(43>0) "a string" else 43  --> here it became any type and compiler unhappy :(
    val aStringOrInt: String | Int = if(43>0) "a string" else 43 // here compiler is happy >_<


    // 3- Intersection types

    trait Camera {
      def takePhoto(): Unit = println("Snap")
    }
    trait Phone {
      def makeCall(): Unit = println("ring")
    }

  def useSmartDevice(sp: Camera & Phone): Unit = {
    sp.takePhoto()
    sp.makeCall()
  }

  class Smartphone extends Camera with Phone

  useSmartDevice(new Smartphone) //ok

  trait HostConfig
  trait HostController {
    def get : Option[HostConfig]
  }

  trait PostConfig
  trait PostController {
    def get: Option[PostConfig]
  }

  def getConfigs(controller: HostController & PostController): Option[HostConfig & PostConfig] = controller.get



  def main(args: Array[String]):Unit = {

  }

}
