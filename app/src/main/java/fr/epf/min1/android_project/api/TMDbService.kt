package fr.epf.min1.android_project

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TMDbService {
    @GET("search/movie")
    suspend fun getFilms(@Query("api_key") api_key:String,@Query("query") query: String?, @Query("page") page: Int): GetFilmsResult

    @GET("movie/{movie_id}")
    suspend fun getFilmById(@Path("movie_id") movie_id:Int, @Query("api_key") api_key:String): GetMovieDetailsResults
    @GET("movie/{movie_id}/recommendations")
    suspend fun getFilmsRecommendations(@Path("movie_id") movie_id:Int, @Query("api_key") api_key:String): GetFilmsRecommendationResult
}

data class GetFilmsResult(
    val page: Int,
    val results: List<Film>,
    val total_results: Int,
    val total_pages: Int
)

data class Film(
    val poster_path: String?,
    val adult: Boolean,
    val overview: String,
    val release_date: String,
    val genre_ids: List<Int>,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String?,
    val popularity: Float,
    val vote_count: Int,
    val video:Boolean,
    val vote_average: Float
)

data class GetMovieDetailsResults(
    val adult: Boolean,
    val backdrop_path: String?,

)