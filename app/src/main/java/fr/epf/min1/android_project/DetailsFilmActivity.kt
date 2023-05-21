package fr.epf.min1.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.TextView
import android.widget.Toast
import com.jackandphantom.carouselrecyclerview.CarouselRecyclerview
import fr.epf.min1.android_project.api.ApiTMDb
import fr.epf.min1.android_project.databinding.ActivityDetailsFilmBinding
import fr.epf.min1.android_project.model.DetailsFilm
import fr.epf.min1.android_project.model.Film
import fr.epf.min1.android_project.model.Genre
import fr.epf.min1.android_project.model.Language
import fr.epf.min1.android_project.model.ProductionCompany
import fr.epf.min1.android_project.model.ProductionCountry
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit
import java.time.LocalDate



class DetailsFilmActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailsFilmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras
        val id = extras?.getInt("film_id") ?: 0

        binding = ActivityDetailsFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (id != 0){
            synchroDetails(id)
            synchroRecommendations(id)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_film_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun synchroDetails(id:Int) {

        val retrofit: Retrofit = ApiTMDb.getInstance()

        val service = retrofit.create(TMDbService::class.java)
        runBlocking {

            //TODO where is the error?
            val filmRes = service.getFilmsRecommendations(id,"8a001113b1bd015692aa418a6bf9a18b")
            Toast.makeText(this@DetailsFilmActivity,"https://api.themoviedb.org/3/movie/${id}&api_key=8a001113b1bd015692aa418a6bf9a18b",Toast.LENGTH_SHORT).show()
            Log.d("EPF", "https://api.themoviedb.org/3/movie/${id}&api_key=8a001113b1bd015692aa418a6bf9a18b")
        //Mapping
//            val genres:List<Genre> = filmRes.genres.map {
//                Genre(it.id,it.name)
//            }
//
//            val productionCompanes:List<ProductionCompany> = filmRes.production_companies.map {
//                ProductionCompany(it.name,it.id,it.logo_path,it.origin_country)
//            }
//
//            val productionCountries:List<ProductionCountry> = filmRes.production_countries.map {
//                ProductionCountry(it.iso_3166_1,it.name)
//            }
//
//            val languages:List<Language> = filmRes.spoken_languages.map {
//                Language(it.iso_639_1,it.name)
//            }
//
//            val film = DetailsFilm(filmRes.adult,
//                filmRes.backdrop_path,
//                filmRes.budget,
//                genres,
//                filmRes.homepage,
//                filmRes.id,
//                filmRes.imdb_id,
//                filmRes.original_language,
//                filmRes.original_title,
//                filmRes.overview,
//                filmRes.popularity,
//                filmRes.poster_path,
//                productionCompanes,
//                productionCountries,
//                LocalDate.parse(filmRes.release_date),
//                filmRes.revenue,
//                filmRes.runtime,
//                languages,
//                filmRes.status,
//                filmRes.tagline,
//                filmRes.title,
//                filmRes.video,
//                filmRes.vote_average,
//                filmRes.vote_count)
//
//
//            //TODO create all widgets in layout/activity_details_film.xml
//            //TODO create recycler view for genre, countries, companies, languages (horizontal)
//            val titleTextView = findViewById<TextView>(R.id.movie_title_details_textView)
//            titleTextView.text = filmRes?.title ?:"TITLE"
        }
    }

    private fun synchroRecommendations(id:Int) {

        val retrofit: Retrofit = ApiTMDb.getInstance()

        val service = retrofit.create(TMDbService::class.java)
        runBlocking {
            val filmRes = service.getFilmsRecommendations(id,"8a001113b1bd015692aa418a6bf9a18b")
            //film view
            val films = filmRes.results.map {
                Film(it.poster_path,
                    it.adult,
                    it.overview,
                    it.release_date,
                    it.genre_ids,
                    it.id,
                    it.original_title,
                    it.original_language,
                    it.title,
                    it.backdrop_path,
                    it.popularity,
                    it.vote_count,
                    it.video,
                    it.vote_average)
            }

            val adapter = RecommendationAdapter(films,this@DetailsFilmActivity)

            binding.apply {
                carouselRecyclerView.adapter = adapter
                carouselRecyclerView.set3DItem(true)
                carouselRecyclerView.setAlpha(true)
                carouselRecyclerView.setInfinite(true)
            }
        }
    }
}