package com.example.session2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.session2nd.R
import kotlinx.android.synthetic.main.nextscreen_activity.*
import kotlinx.android.synthetic.main.signup_main.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_main)

        button.setOnClickListener {

            if (TextUtils.isEmpty(editText.getText())) {
                editText4.setError("password is requires!")
                editText2.setError("email is required!")
                editText3.setError("phone number is required")
                editText.setError("name is required")
            } else {
                val intent = Intent(this,NextscreenActivity::class.java)
                intent.putExtra("pass",editText4.text.toString());
                intent.putExtra("email",editText2.text.toString());
                intent.putExtra("phonenum",editText3.text.toString());
                intent.putExtra("name",editText.text.toString());
                startActivity(intent)

            }



        }


}}
