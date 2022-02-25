package entities
import org.slf4j.LoggerFactory


case class Movie(
                  imdb_title_id:String,
                 title:String,
                 original_title:String,
                 year	:Int,
                 date_published:String,
                 genre	:String,
                 duration:Int,
                 country:String,
                 language:String,
                 director:String,
                 writer:String,
                  production_company:String,
                 actors	:String,
                 description	:String,
                  avg_vote	:Int,
                 votes:Int,
                 budget:String,
                  usa_gross_income	:String,
                  worlwide_gross_income	:String,
                 metascore	:Int,
                  reviews_from_users:Int,
                  reviews_from_critics:Int)

object Movie {
  import Parsers._

  private val logger = LoggerFactory.getLogger(this.getClass)

  def parse(row: Map[String, String]): Option[Movie] = {
    // header from the CSV file:
    // adult,belongs_to_collection,budget,genres,homepage,id,imdb_id,original_language,original_title,overview,popularity,poster_path,production_companies,production_countries,release_date,revenue,runtime,spoken_languages,status,tagline,title,video,vote_average,vote_count

    val movie = for {
      /* MANDATORY FIELDS */
      imdb_title_id<- parseString (row,"imdb_title_id")
      title <- parseString(row," title")
      original_title <- parseString(row,"original_title")
      year<- parseInt(row,"year")
      date_published<- parseString(row," date_published")
      genre<- parseString(row,"genre")
      duration<- parseInt(row,"duration")
      country <- parseString(row,"country")
      language<- parseString(row," language")
      director<- parseString(row,"director")
      writer<- parseString(row," writer")
      production_company<- parseString(row," production_company")
      actors<- parseString(row," actors")
      description<- parseString(row,"description")
      avg_vote<- parseInt(row,"avg_vote")
      votes<- parseInt(row,"votes")
      budget<- parseString(row,"budget")
      usa_gross_income<- parseString(row,"usa_gross_income")
      worlwide_gross_income<- parseString(row,"worlwide_gross_income")
      metastore<- parseInt(row,"metastore")
      reviews_from_users<- parseInt(row,"reviews_from_users")
      reviews_from_critics<- parseInt(row,"reviews_from_critics")

    } yield {

      Movie(
        imdb_title_id,
      title,
      original_title,
      year,
      date_published,
      genre,
      duration,
      country,
      language,
      director,
      writer,
      production_company,
      actors,
      description,
      avg_vote,
      votes,
      budget,
      usa_gross_income,
      worlwide_gross_income,
      metastore,
      reviews_from_users,
      reviews_from_critics)
    }
    //   if (movie.isEmpty) logger.warn(s"Skipping malformed movie row")
    movie
  }
}