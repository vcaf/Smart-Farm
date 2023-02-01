package com.avansb.smartfarm

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.sql.SQLClientInfoException
import java.sql.SQLException

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        val edittext_email= findViewById<EditText>(R.id.ET_email_Activity_ForgotPass)
        var edittext_comfirm_email = findViewById<EditText>(R.id.ET_comfirm_email_Activity_ForgotPass)

        val btn_click_me = findViewById<Button>(R.id.Button_send_Activity_ForgotPass)
        btn_click_me.setOnClickListener {
            try {
                if(TextUtils.isEmpty(edittext_email.text.toString())&&  TextUtils.isEmpty(edittext_comfirm_email.text.toString())){
                    Toast.makeText(this@ForgotPasswordActivity, "fill in your email!.", Toast.LENGTH_SHORT).show()
                }else if (edittext_email.text.contains("@")){
                    Toast.makeText(this@ForgotPasswordActivity, "fill a correct email adress!.", Toast.LENGTH_SHORT).show()
                }else if(edittext_email.text.equals(edittext_comfirm_email.text) ){
                    Toast.makeText(this@ForgotPasswordActivity, "Email has been sent!.", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this@ForgotPasswordActivity, "Emails are not the same!.", Toast.LENGTH_SHORT).show()
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
    }
}