package com.example.alertdialogbox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alertdialogbox.databinding.ActivityMainBinding
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    var selectedDay : Int = 0
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)

            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setTitle("Are You Sure ?")
            builder1.setMessage("Do you want to exit")
            builder1.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->

            })
            builder1.setPositiveButton("Yes",DialogInterface.OnClickListener { dialog, which ->
                finish()
            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val weeks = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Select Day")
            builder2.setSingleChoiceItems(weeks,0,DialogInterface.OnClickListener { dialog, which ->

                selectedDay = which
            })
            builder2.setNegativeButton("Reject",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"You Select ${weeks[selectedDay]}",Toast.LENGTH_SHORT).show()

            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val weeks = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
            val builder2 = AlertDialog.Builder(this)

            builder2.setTitle("Select Day")
            builder2.setMultiChoiceItems(weeks,null,DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this,"You Select ${weeks[which]}",Toast.LENGTH_SHORT).show()
            })
            builder2.setNegativeButton("Reject",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.setPositiveButton("Submit",DialogInterface.OnClickListener { dialog, which ->

            })
            builder2.show()

        }

    }
}