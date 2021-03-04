package com.example.session2

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.session2nd.R
import kotlinx.android.synthetic.main.nextscreen_activity.*


class NextscreenActivity : AppCompatActivity() {

    private var pass: String? = null
    private var email: String? = null
    private var phonenum: String? = null
    private var name: String? = null
    private val MY_CAMERA_REQUEST_CODE = 100
    private val CAMERA_PIC_REQUEST = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextscreen_activity)

        if(intent!=null)
        {

            if(intent.hasExtra("pass"))
            {

                pass = intent.getStringExtra("pass")
                textView6.text =(pass);"is your password";


            }
            if(intent.hasExtra("email"))
            {

                email = intent.getStringExtra("email")
                textView4.text =email;"is your email";
            }
            if(intent.hasExtra("phonenum"))
            {

                phonenum = intent.getStringExtra("phonenum")
                textView5.text =phonenum;"is your phone number";

            }
            if(intent.hasExtra("name"))
            {

                name = intent.getStringExtra("name")
                textView3.text =name;"is your name";
            }


            button2.setOnClickListener {
                val x=findViewById<EditText>(R.id.editText5)

                if (x.text.toString().isNullOrEmpty()){

                    Toast.makeText(this,"Error in url",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }


                val url = "http://www."+x.text.toString()+".com"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
            }



        }

        button3.setOnClickListener {

            if (checkPermission())
            else
                requestPermission()
        }


    }
    private fun checkPermission(): Boolean {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }



    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(Manifest.permission.CAMERA),
            MY_CAMERA_REQUEST_CODE
        )
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            MY_CAMERA_REQUEST_CODE -> if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(applicationContext, "Permission Granted", Toast.LENGTH_SHORT).show()

                // open camera
            } else {
                Toast.makeText(applicationContext, "Permission Denied", Toast.LENGTH_SHORT).show()
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED
                    ) {
                        Toast.makeText(
                            this,
                            "You need to allow access permissions",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}
