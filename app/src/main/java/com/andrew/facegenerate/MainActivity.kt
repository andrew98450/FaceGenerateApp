package com.andrew.facegenerate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import com.loopj.android.http.AsyncHttpClient

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText = findViewById<EditText>(R.id.editTextN)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnGenerate = findViewById<Button>(R.id.buttonGenerate)
        val imageView = findViewById<ImageView>(R.id.imageView)
        val baseUrl = "https://facegenerate-jv7hfrvpwa-uc.a.run.app"
        val httpClient = AsyncHttpClient()
        btnGenerate.setOnClickListener {
            val n = editText.text.toString().toInt()
            when(radioGroup.checkedRadioButtonId) {
                R.id.radioButtonFemale -> {
                    val url = baseUrl + String.format("/image/%d/%d", n, 1)
                    httpClient.get(url, ImageHttpResponseHandler(imageView))
                }
                R.id.radioButtonMale -> {
                    val url = baseUrl + String.format("/image/%d/%d", n, 2)
                    httpClient.get(url, ImageHttpResponseHandler(imageView))
                }
                R.id.radioButtonRandom -> {
                    val url = baseUrl + String.format("/image/%d/%d", n, 3)
                    httpClient.get(url, ImageHttpResponseHandler(imageView))
                }
            }
        }
    }
}