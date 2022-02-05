package com.example.quotes_app_k

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var pd : ProgressDialog? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            Request_manager (this).GetAllQuote(listner)
        pd = ProgressDialog(this)
        pd?.setTitle("Loading..")
        pd?.show()
    }

    private val listner : QuotesResponseListeners = object : QuotesResponseListeners
    {
        override fun fetch(responses: List<QuotesResponses>, message: String) {
            pd?.dismiss()
            recycler_view_home_id.setHasFixedSize(true);
            recycler_view_home_id.layoutManager= StaggeredGridLayoutManager(2 , LinearLayoutManager.VERTICAL)
            val adapter = Quotes_list_adapter(this@MainActivity, responses)
            recycler_view_home_id.adapter = adapter
        }

        override fun error(message: String) {
            pd?.dismiss()
            Toast.makeText(this@MainActivity, message , Toast.LENGTH_LONG).show()

        }

    }
}