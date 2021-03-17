package miranda.fernanda.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import java.util.*

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""

        if(bundle != null){

            ns = bundle.getInt("numberSeats")
            iv_img_pelicula.setImageResource(bundle.getInt("header"))
            title = bundle.getString("titulo")!!
            tv_nombre_pelicula.setText(title)
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns  seats available")
            id=bundle.getInt("pos")

        }

        if(ns==0){
            buyTickets.isEnabled = false
        }else {
            val random = Random()
            val seats= random.nextInt(21)
            seatsLeft.setText("$seats  seats available")
            buyTickets.setOnClickListener {
                val intent: Intent = Intent(this, SeatsSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("title", title)
                intent.putExtra("seats", seats)
                this.startActivity(intent)
            }
        }

    }
}