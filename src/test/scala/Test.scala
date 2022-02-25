
import org.scalatest.funsuite.AnyFunSuite
class Test extends AnyFunSuite {
  test("director name") {
    //println(MovieApp.question())
    var data = MovieApp.question()
    for (mapOfMOvieFileds <- data) {

      val director: String = mapOfMOvieFileds("director")
      val yearOfRelease: Int = mapOfMOvieFileds("year").toInt

      //      if((mapOfMOvieFileds("director")=="D.W. Griffith")&&(mapOfMOvieFileds("year") >=1914)){
      assert(director.equals("D.W. Griffith") && ((yearOfRelease == 1914)))

    }
  }
}
