package kz.almat.requestcodeandresualtcode

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val REQUEST_CODE_COLOR = 1
    val REQUEST_CODE_ALIGN = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAlign.setOnClickListener(this)
        btnColor.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val intent: Intent
        when (v!!.id) {
            R.id.btnColor -> {
                intent = Intent(this, ColorActivity::class.java)
                startActivityForResult(intent,REQUEST_CODE_COLOR)
            }
            R.id.btnAlign -> {
                intent = Intent(this, AlignActivity::class.java)
                startActivityForResult(intent,REQUEST_CODE_ALIGN)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("myLos", "requestCode = $requestCode , resultCode = $resultCode" )

        if (resultCode == RESULT_OK) {
            when (requestCode) {
                REQUEST_CODE_COLOR -> {
                    var color = data!!.getIntExtra("color", Color.WHITE)
                    tvText.setTextColor(color)
                }
                REQUEST_CODE_ALIGN -> {
                    var align = data!!.getIntExtra("aligment", Gravity.LEFT)
                    tvText.gravity = align
                }
            }
        } else {
            Toast.makeText(this, "Wrong result", Toast.LENGTH_SHORT).show()
        }
    }
}
