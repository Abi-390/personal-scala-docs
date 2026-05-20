package blog

object TypeLambdas {

  /*
  - kinds = types of types
  - Int, String = value-level kind (level -0) => attach to values
  - List, Option = level-1 kind ("generics")
  - Functor, Monad = level-2 kind ("generics of generics")
  * */

  val aNumber: Int = 42 // level -0 directly assigning type Int
  val aList: List[Int] = ??? // Level -1 we can't directly write aList: List we have to pass level-0 type as argument to list-> aList :List[Int]

  class Functor[F[_]]

  val functorOption = new Functor[Option]

  // List is similar to a function = type constructor
  type MyList = [T] =>> List[T] // MyList =====List , this is type lambda shit

  type MapWithStringKey = [T] =>> Map[String, T]
  val addressBook: MapWithStringKey[String] = Map()
  type MapWithStringKey2[T] = Map[String, T] // exactly same


  def main(args: Array[String]): Unit = {

  }

}
