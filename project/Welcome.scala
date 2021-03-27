import sbtwelcome._

object Welcome {

  val logo =
    """|                          
       | __      ___      _             _           _     
       | \ \    / (_)    | |           | |         | |    
       |  \ \  / / _ _ __| |_ _   _ ___| |     __ _| |__  
       |   \ \/ / | | '__| __| | | / __| |    / _` | '_ \ 
       |    \  /  | | |  | |_| |_| \__ \ |___| (_| | |_) |
       |     \/   |_|_|   \__|\__,_|___/______\__,_|_.__/ 
       |                                                  
       |""".stripMargin

  val tasks = Seq(
    UsefulTask(
      "",
      "run",
      "Run Main class"
    ),
    UsefulTask(
      "",
      "test",
      "Run all tests"
    ),
    UsefulTask(
      "",
      "testOnly com.virtuslab.TestClass",
      "run a specific test class"
    ),
    UsefulTask(
      "",
      "reload",
      "Refresh sbt after changes to any sbt file."
    ),
  )

}
