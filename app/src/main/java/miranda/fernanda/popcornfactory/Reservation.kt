package miranda.fernanda.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*
import kotlinx.android.synthetic.main.activity_reservation.*

class Reservation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        val bundle= intent.extras
        var seat = -1
        if(bundle!=null) {
            title = bundle.getString("title")!!
            titleTexV.setText("Movie: $title ")
            seat = bundle.getInt("seat")
            seatTexv.setText("Seat: $seat")
        }
    }
}