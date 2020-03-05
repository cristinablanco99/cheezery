package mx.itson.thecheezery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        btn_colddrinks.setOnClickListener {
           var intent= Intent(this, ColdDrinksActivity::class.java)
            startActivity(intent)
        }
        btn_hotdrinks.setOnClickListener {
            var intent= Intent(this, HotDrinksActivity::class.java)
            startActivity(intent)
        }

        btn_3.setOnClickListener {
            var intent= Intent(this, SweetsActivity::class.java)
            startActivity(intent)
        }

        btn_4.setOnClickListener {
            var intent= Intent(this, SaltyActivity::class.java)
            startActivity(intent)
        }

        btn_5.setOnClickListener {
            var intent= Intent(this, ComboActivity::class.java)
            startActivity(intent)
        }

        btn_6.setOnClickListener {
            var intent= Intent(this, PersonalizedActivity::class.java)
            startActivity(intent)
        }


    }
}
