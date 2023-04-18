package fr.epf.min1.android_project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epf.min1.android_project.api.ApiTMDb
import fr.epf.min1.android_project.api.AppConstants
import kotlinx.coroutines.runBlocking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class ListFilmActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_film)


        recyclerView = findViewById<RecyclerView>(R.id.list_film_recyclerview)

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.list_film_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_scan_qr_code -> {
//                val intent = Intent(this, AddClientActivity::class.java)
//                startActivity(intent)
            }
            R.id.action_sync -> {
                synchro()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun synchro() {
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://randomuser.me/")
//            //addConverter Moshi pour mapper en obj java
//            .addConverterFactory(MoshiConverterFactory.create())
//            .build()

//        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }
//        val client = OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()

        val retrofit = ApiTMDb.getInstance()

        val service = retrofit.create(TMDbService::class.java)

        runBlocking {
//            val films = service.getFilms(AppConstants.TMDB_KEY_V3,"rain",1).results.map{
//                Film(it.name.last,it.name.first,if(it.gender=="male")Gender.MAN else Gender.WOMAN)
//            }
            val films = service.getFilms(AppConstants.TMDB_KEY_V3,"rain",1).results
            recyclerView.adapter = FilmAdapter(films, this@ListFilmActivity)
        }

    }
}