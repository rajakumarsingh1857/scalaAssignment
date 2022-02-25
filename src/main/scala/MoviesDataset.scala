


//import MovieApp.movies
import com.github.tototoshi.csv.*
import entities.Movie
import org.slf4j.{Logger, LoggerFactory}
import scala.io.Source

class MoviesDataset(moviesMetadataFile: String) {

  private val logger: Logger = LoggerFactory.getLogger(this.getClass)

  val movies: List[Movie] = {
    val rawData = loadCSVFile(moviesMetadataFile)
    rawData.flatMap { raw =>
      // skipping malformed rows that are malformed
      Movie.parse(raw)
    }
  }

  def loadCSVFile(path: String): List[Map[String, String]] = {
    logger.info(s"Processing file $path...")
    val file = Source.fromResource(path)
    val reader = CSVReader.open(file)
    val data = reader.allWithHeaders()
//    data.foreach(println)
   
    logger.info(s"Completed processing of file $path! ${data.size} records loaded")
    data
  }

}