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

class SingupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_singup)
        val edittext_name= findViewById(R.id.ET_full_name_Activity_Signup) as EditText
        val edittext_email= findViewById(R.id.ET_email_Activity_Signup) as EditText
        val edittext_password = findViewById(R.id.ET_password_Activity_Signup) as EditText
        val edittext_comfirm_password = findViewById(R.id.ET_comfirm_password_Activity_Signup) as EditText

        val tv_forgot_password = findViewById(R.id.TV_forgotpassword_Activity_Signup) as TextView
        val tv_signup = findViewById(R.id.TV_Signin_Activity_Signup) as TextView

        val btn_click_me = findViewById(R.id.Button_Sign_Up_Activity_Signup) as Button

        btn_click_me.setOnClickListener {
            try {
                if(TextUtils.isEmpty(edittext_name.text.toString())&&  TextUtils.isEmpty(edittext_email.text.toString())&&TextUtils.isEmpty(edittext_password.text.toString())&&  TextUtils.isEmpty(edittext_comfirm_password.text.toString())){
                    Toast.makeText(this@SingupActivity, "fill in all the fields to make an account!.", Toast.LENGTH_SHORT).show()
                }else if (edittext_email.text.contains("@")){
                    Toast.makeText(this@SingupActivity, "fill a correct email adress!.", Toast.LENGTH_SHORT).show()
                }else if(edittext_password.equals(edittext_comfirm_password) ){
                        Toast.makeText(this@SingupActivity, "Signup.", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this@SingupActivity, "Passwords are not the same!.", Toast.LENGTH_SHORT).show()
                    }
            }catch (a: SQLException){
                val client_Ex = SQLClientInfoException()
                client_Ex.initCause(a)
                System.out.println("A sqlException has occured")
            }catch (a: Exception){
                a.printStackTrace()
                System.out.println("A Exception has occured")
            }
        }

        tv_forgot_password.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        tv_signup.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}