package com.tare.githubbrowser.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun formatDate(date: String): String{
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH)
        val outputFormat = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
        return try {
            val formatted = inputFormat.parse(date)!!
            outputFormat.format(formatted)
        }catch (e: ParseException){
            ""
        }
    }
}