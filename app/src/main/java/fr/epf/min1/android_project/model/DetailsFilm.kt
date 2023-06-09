package fr.epf.min1.android_project.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class MovieDetail(
    val adult: Boolean, //details
    val backdrop_path: String,
    val budget: Int, //details
    val belongs_to_collection: Collection,
    val genres: List<Genre>,
    val id: Int,
    val homepage: String,
    val imdb_id: String,
    val name: String,
    val original_language: String, //details
    val original_title: String, //details
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val production_companies: List<ProductionCompany>, //details
    val production_countries: List<ProductionCountry>,
    val release_date: String, //details
    val revenue: Long,
    val runtime: Int,
    val spoken_languages: List<Language>, //details
    val status: String,
    val tagline: String, //details
    val title: String,
    val video: Boolean,
    val vote_average: Float, //rating
    val vote_count: Int //with average
) : Parcelable {
    override fun toString(): String {
        return "MovieDetail(adult=$adult, backdrop_path='$backdrop_path', budget=$budget, belongs_to_collection=$belongs_to_collection, genres=$genres, id=$id, homepage='$homepage', imdb_id='$imdb_id', name='$name', original_language='$original_language', original_title='$original_title', overview='$overview', popularity=$popularity, poster_path='$poster_path', production_companies=$production_companies, production_contries=$production_countries, release_date='$release_date', revenue=$revenue, runtime=$runtime, spoken_languages=$spoken_languages, status='$status', tagline='$tagline', title='$title', video=$video, vote_average=$vote_average, vote_count=$vote_count)"
    }
    fun toStringAdult(): String {
        return if ( adult ) "Adult movie" else ""
    }

}


@Parcelize
data class Language(
    val english_name: String,
    val iso_639_1: String,
    val name: String
) : Parcelable {
    override fun toString(): String {
        return "\n$name"
    }
}

@Parcelize
data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
) : Parcelable {
    override fun toString(): String {
        return "ProductionCountries(iso_3166_1='$iso_3166_1', name='$name')"
    }
}

@Parcelize
data class ProductionCompany(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
) : Parcelable {
    override fun toString(): String {
        return "\n$name $origin_country"
    }
}

@Parcelize
data class Collection(
    val id: Int,
    val name: String,
    val poster_path: String,
    val backdrop_path: String
) : Parcelable

@Parcelize
data class Genre(
    val id: Int,
    val name: String
) : Parcelable{
    override fun toString(): String {
        return name
    }
}

/**
 *
 * Doc: https://developer.android.com/kotlin/parcelize?hl=fr
 *
 */