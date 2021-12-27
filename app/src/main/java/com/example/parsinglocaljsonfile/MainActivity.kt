package com.example.parsinglocaljsonfile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import java.io.InputStream
import java.lang.Exception
import java.io.InputStreamReader
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var myRV: RecyclerView
    lateinit var rvAdapter: RVAdapter
    private var imgList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myRV = findViewById(R.id.rvMain)
        rvAdapter = RVAdapter(this@MainActivity, imgList)
        myRV.adapter = rvAdapter
        myRV.layoutManager = LinearLayoutManager(applicationContext)

        parseJson()
    }

    fun parseJson() {
        try {
            val inputStream: InputStream = assets.open("data.json")
            val json = inputStream.bufferedReader().use { it.readText() }
            val jsonArray = JSONArray(json)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i).getString("url")
                imgList.add(jsonObject)

            }
        } catch (e: Exception) {
            Log.d("main-error", "$e")
        }

    }
}