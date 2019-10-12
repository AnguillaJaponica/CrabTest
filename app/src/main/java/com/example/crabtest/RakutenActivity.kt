package com.example.crabtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_rakuten.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RakutenActivity : AppCompatActivity() {

    private val itemInterface by lazy { createService() }

    interface ItemInterface {
        @GET("IchibaItem/Ranking/20170628?formatVersion=2&applicationId=1023624277478877278")
        fun items(): retrofit2.Call<RakutenRankingResult>
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rakuten)
    }

    fun createService(): ItemInterface {
        val baseApiUrl = "https://app.rakuten.co.jp/services/api/"

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val httpLogging =
            httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        val httpClientBuilder = OkHttpClient.Builder().addInterceptor(httpLogging)

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseApiUrl)
            .client(httpClientBuilder.build())
            .build()

        return retrofit.create(ItemInterface::class.java)
    }

    fun getRanking(v: View){
        itemInterface.items().enqueue(object : retrofit2.Callback<RakutenRankingResult> {
            override fun onFailure(call: retrofit2.Call<RakutenRankingResult>?, t: Throwable?) {
            }

            override fun onResponse(call: retrofit2.Call<RakutenRankingResult>?, response: retrofit2.Response<RakutenRankingResult>) {
                if (response.isSuccessful) {
                    response.body()?.let {

                        var items = mutableListOf<String>()
                        var res = response.body()?.Items?.iterator()

                        var title = response.body()!!.title
                        titleRanking.text = "$title"

                        if (res != null) {
                            for (item in res) {
                                items.add(item.itemName)
                            }
                        }

                        val adapter = ArrayAdapter(this@RakutenActivity, android.R.layout.simple_list_item_1, items)
                        val list: ListView = findViewById(R.id.listRanking)
                        list.adapter = adapter
                    }
                }
            }
        })
    }
}
