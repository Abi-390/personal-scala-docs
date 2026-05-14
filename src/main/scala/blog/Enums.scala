package blog

object Enums {

enum Permissions {
  case READ, WRITE, EXEC, NONE
}

  /*
So when we define something like this the compiler automatically creates these -  it creates a sealed class called permissions.
It also creates this values:  READ, WRITE , EXEC, NONE . These values will extend permissions and they will be constants.We will
be able to access these values from the permission's companion object which will also be automatically created.
*/

val read:Permissions = Permissions.READ


//Enum with args

enum PermissionWithBits( val bits:Int) {
  case READ extends PermissionWithBits(4)      // basically binary bit 100
  case WRITE extends PermissionWithBits(2)     // binary bit 010
  case EXEC extends  PermissionWithBits(1)     // binary bit 001
  case NONE extends PermissionWithBits(0)      // binary bit 000

  def toHex: String = Integer.toHexString(bits)
}

object PermissionsWithBits {                   // companion object for enum PermissionWithBits
  def fromBits(bits:Int):PermissionWithBits = // do bit checking
  PermissionWithBits.NONE // for now none
}

  val read2:PermissionWithBits = PermissionWithBits.READ
  val bitString = read2.bits
  val hexString = read2.toHex

  //Standard API
  val first = Permissions.READ.ordinal // ordinal method returns an integer pointing the index of read inside the enum
                                      // basically converted the enum to an int

  val allPermissions =  Permissions.values   // array with all the possible values
  val readPermission: Permissions = Permissions.valueOf("READ") // Permissions.READ

  def main(args: Array[String]):Unit = {
      allPermissions.foreach(println)  // will basically print all the values inside the permissions enum
    println(s"This is readPermission result : $readPermission")
    }
}
