package edu.rvc.student.week5
//Paul Stanek
//CIS-245-D010
//Week 5 Assignment
//2/4/2018

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.RadioButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var txtName = findViewById<EditText>(R.id.txtName)
        var txtEmail = findViewById<EditText>(R.id.txtEmail)
        var rbMale = findViewById<RadioButton>(R.id.rbMale)
        var rbFemale = findViewById<RadioButton>(R.id.rbFemale)
        var btnSubmit = findViewById<Button>(R.id.btnSubmit)
        var txtShow = findViewById<TextView>(R.id.txtShow)

        btnSubmit.setOnClickListener {
            if (rbMale.isChecked){
                txtShow.text = ("Hello, ${txtName.text.toString()}. The Men's bathroom is located near the East side of the main entrance." +
                        "  A map of the facility is being emailed to ${txtEmail.text.toString()}").toString()
                txtName.setText("")
                txtEmail.setText("")
                hideKeyboard()
            }
            else if (rbFemale.isChecked){
                txtShow.text = ("Hello, ${txtName.text.toString()}. The Women's bathroom is located near the West side of the main entrance." +
                        "  A map of the facility is being emailed to ${txtEmail.text.toString()}").toString()
                txtName.setText("")
                txtEmail.setText("")
                hideKeyboard()
            }
            else {
                hideKeyboard()
                Toast.makeText( this,  "Please select either Male or Female and click Submit", Toast.LENGTH_LONG) .show()
            }
        }
    }

    fun hideKeyboard(){
        try{
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception){
            // TODO: handle exception
        }
    }


}
