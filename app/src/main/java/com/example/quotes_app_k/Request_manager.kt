package com.example.quotes_app_k

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Request_manager (mContext: Context){
    var retrofit = Retrofit.Builder().baseUrl("https://type.fit/")
        .addConverterFactory(GsonConverterFactory.create()).build()


    fun GetAllQuote(listener: QuotesResponseListeners)
    {
        val call=retrofit.create(CallQuote::class.java).callQuote()
        call.enqueue(object: Callback<List<QuotesResponses>>{
            override fun onResponse(
                call: Call<List<QuotesResponses>>,
                response: Response<List<QuotesResponses>>
            ) {
                if(!response.isSuccessful)
                {
                    listener.error(response.message())
                    return
                }
                response.body()?.let { listener.fetch(it, response.message()) }
            }

            override fun onFailure(call: Call<List<QuotesResponses>>, t: Throwable) {
                t.message?.let { listener.error(it) }
            }

        })
    }



        private interface CallQuote{
            @GET("api/quotes")
            fun callQuote(): Call<List<QuotesResponses>>
        }

}