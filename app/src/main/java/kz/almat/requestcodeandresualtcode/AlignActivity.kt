package kz.almat.requestcodeandresualtcode

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import kotlinx.android.synthetic.main.activity_align.*

class AlignActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_align)

        btnLeft.setOnClickListener(this)
        btnCenter.setOnClickListener(this)
        btnRight.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        var intent = Intent()
        when (v!!.id) {
            R.id.btnLeft -> {
                intent.putExtra("aligment", Gravity.LEFT)
            }
            R.id.btnCenter -> {
                intent.putExtra("aligment", Gravity.CENTER)
            }
            R.id.btnRight -> {
                intent.putExtra("aligment", Gravity.RIGHT)
            }
        }
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
