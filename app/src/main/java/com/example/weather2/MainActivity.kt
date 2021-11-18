package com.example.weather2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.net.URL
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttonLoadWeather: Button
    private lateinit var textViewJson: TextView
    private lateinit var apiWorker: ApiWorker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url = "https://api.weather.yandex.ru/v2/forecast?lat=53.75396&lon=34.620393"


        var headers = HashMap<String, String>()
        headers["X-Yandex-API-Key"] = "6028d88a-ee11-488b-9a3b-caee6212a7b9"

        apiWorker = ApiWorker(applicationContext)

        textViewJson = findViewById(R.id.textViewJson)

        buttonLoadWeather = findViewById(R.id.buttonLoadWeather)
        buttonLoadWeather.setOnClickListener {
            apiWorker.makeGetRequest(url,::updateTextViewJson,headers)
        }
    }

    fun updateTextViewJson(data: String){
        textViewJson.text = data
    }
}