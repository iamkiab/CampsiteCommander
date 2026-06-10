package com.example.campsitecommander

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class secondScreen : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)
        val btnQuantity = findViewById<Button>(R.id.btnQuantity)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val txtOutput = findViewById<TextView>(R.id.txtOutput)
        
        btnDisplay.setOnClickListener { 
            var output = ""
            for (i in MainActivity.itemArray.indices) {
                output += "Item: ${MainActivity.itemArray[i]}\n" +
                          "Category: ${MainActivity.categoryArray[i]}\n" +
                          "Quantity: ${MainActivity.quantityArray[i]}\n" +
                          "Comments: ${MainActivity.commentsArray[i]}\n\n"
            }
            txtOutput.text = output
            Log.d("CAMPSITE_COMMANDER", "Displayed full inventory")
        }
        
        btnQuantity.setOnClickListener { 
            var output = "" 
            for (i in MainActivity.quantityArray.indices) {
                if (MainActivity.quantityArray[i] >= 2) {
                    output += "${MainActivity.itemArray[i]} - Quantity: ${MainActivity.quantityArray[i]}\n"
                }
            }
            txtOutput.text = output
            Log.d("CAMPSITE_COMMANDER", "Displayed quantity >= 2")
        }
        
        btnExit.setOnClickListener { 
            finish()
        } 
    }
}
