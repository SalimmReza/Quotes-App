package com.example.quotes_app_k

interface QuotesResponseListeners {
    fun fetch(responses: List<QuotesResponses>, message:String)
    fun error(message: String)

}