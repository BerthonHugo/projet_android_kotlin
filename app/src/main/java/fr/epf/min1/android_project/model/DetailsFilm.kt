package fr.epf.min1.android_project.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import java.time.LocalDate
@Parcelize
data class DetailsFilm (
    val adult: Boolean,
    val backdrop_path: String?,
    val budget: Int,
    val genres:List<Genre>,
    val homepage:String?,
    val id:Int,
    val imdb_id:Int?,
    val original_language:String,
    val original_title: String,
    val overview:String,
    val popularity:Float,
    val poster_path:String?,
    val production_companies: List<ProductionCompany>,
    val production_countries: List<ProductionCountry>,
    val release_date: LocalDate,
    val revenue:Int,
    val runtime:Int?,
    val spoken_languages: List<Language>,
    val status:String,
    val tagline:String?,
    val title: String,
    val video:Boolean,
    val vote_average:Float,
    val vote_count:Int
):Parcelable{}
@Parcelize
data class ProductionCountry(
    val iso_3166_1:String,
    val name:String
):Parcelable{}
@Parcelize
data class ProductionCompany(
    val name:String,
    val id:Int,
    val logo_path:String?,
    val origin_country:String
):Parcelable{}
@Parcelize
data class Language(
    val iso_639_1:String,
    val name:String
):Parcelable{}
@Parcelize
data class Genre(
    val id:Int,
    val name:String
): Parcelable {}