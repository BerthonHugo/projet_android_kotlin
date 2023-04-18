package fr.epf.min1.android_project

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class FilmViewHolder(val view: View): RecyclerView.ViewHolder(view)

class FilmAdapter(val films:List<Film>,val context: Context): RecyclerView.Adapter<FilmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.film_view, parent, false)
        return FilmViewHolder(view)
    }

    override fun getItemCount(): Int = films.size

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {

        val film : Film = films[position]

        val view = holder.itemView

//        val textView = view.findViewById<TextView>(R.id.client_view_textview)
//        textView.text = film.fullName
//        //       textView.text = "${client.firstName} ${client.lastName}"
//
//        val imageView = view.findViewById<ImageView>(R.id.client_view_imageview)
//        /*    imageView.setImageResource(
//                when(client.gender){
//                    Gender.MAN -> R.drawable.man
//                    Gender.WOMAN -> R.drawable.woman
//                }
//            )  */
//        imageView.setImageResource(client.getImage())

        val cardView = view.findViewById<CardView>(R.id.film_view_cardview)
        cardView.setOnClickListener {
            val intent = Intent(context, DetailsFilmActivity::class.java)
            intent.putExtra("film_id", film.id)
//            intent.putExtra("client", client)
            context.startActivity(intent)
        }
    }


}