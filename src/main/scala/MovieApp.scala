import scala.collection.mutable.ListBuffer
import scala.language.postfixOps

object MovieApp extends App {
  def question(): ListBuffer[Map[String, String]] = {
    val dataset = new MoviesDataset("movies_dataset (1).csv")
    val movies = dataset.loadCSVFile("movies_dataset (1).csv")
    var res = ListBuffer[Map[String, String]]()

    for (mapOfMOvieFileds <- movies) {

      val director: String = mapOfMOvieFileds("director")
      val yearOfRelease: Int = mapOfMOvieFileds("year").toInt

      //      if((mapOfMOvieFileds("director")=="D.W. Griffith")&&(mapOfMOvieFileds("year") >=1914)){
      if (director.equals("D.W. Griffith") && ((yearOfRelease == 1914))) {
        res += mapOfMOvieFileds
        mapOfMOvieFileds.keys.foreach {
          key =>
            print(s"$key ")
            print(s": ${mapOfMOvieFileds(key)}")
            println()
            println(".............................................................")

        }

        println("888888888888888888888888888888888888888888888888888888888888888888")
      }
      print(res)

    }
    res
  }

  question()
}