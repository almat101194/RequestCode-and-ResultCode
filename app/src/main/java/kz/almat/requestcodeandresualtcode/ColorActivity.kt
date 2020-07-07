package kz.almat.requestcodeandresualtcode

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_color.*

class ColorActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        btnBlue.setOnClickListener(this)
        btnGreen.setOnClickListener(this)
        btnRed.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()
        when (v!!.id) {
            R.id.btnRed -> {
                intent.putExtra("color", Color.RED)
            }
            R.id.btnGreen -> {
                intent.putExtra("color", Color.GREEN)
            }
            R.id.btnBlue -> {
                intent.putExtra("color", Color.BLUE)
            }
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
