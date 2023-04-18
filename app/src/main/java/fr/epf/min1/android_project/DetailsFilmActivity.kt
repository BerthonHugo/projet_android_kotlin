package fr.epf.min1.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu


class DetailsFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_film)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.details_film_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }
}