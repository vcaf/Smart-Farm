package com.avansb.smartfarm

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.SQLClientInfoException
import java.sql.SQLException

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_login)
                val edittext_email= findViewById(R.id.ET_email_Activity_Login) as EditText
                val edittext_password = findViewById(R.id.ET_password_Activity_Login) as EditText

                val tv_forgot_password = findViewById(R.id.TV_forgotpassword_Activity_Login) as TextView
                val tv_signup = findViewById(R.id.TV_Signup_Activity_Login) as TextView

                val btn_click_me = findViewById(R.id.Button_login_Activity_Login) as Button

                btn_click_me.setOnClickListener {
                    try {
                        if(TextUtils.isEmpty(edittext_email.text.toString())&&  TextUtils.isEmpty(edittext_password.text.toString())){
                            Toast.makeText(this@LoginActivity, "fill in your email and password!.", Toast.LENGTH_SHORT).show()
                        }else {
                            Toast.makeText(this@LoginActivity, "LogIn.", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this, HomeActivity::class.java)
                            // start your next activity
                            startActivity(intent)
                        }}catch (a: SQLException){
                        val client_Ex = SQLClientInfoException()
                        client_Ex.initCause(a)
                        System.out.println("A sqlException has occured")

                    }catch (a: Exception){
                        a.printStackTrace()
                        System.out.println("A Exception has occured")
                    }
                }

                tv_forgot_password.setOnClickListener {
                    // your code to run when the user clicks on the TextView
                    val intent = Intent(this, ForgotPasswordActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }

                tv_signup.setOnClickListener {
                    // your code to run when the user clicks on the TextView
                    val intent = Intent(this, SingupActivity::class.java)
                    // start your next activity
                    startActivity(intent)
                }

    }
}