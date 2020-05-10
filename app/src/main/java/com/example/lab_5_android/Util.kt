package com.example.lab_5_android

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.example.lab_5_android.database.Guest



fun formatGuests(guests: List<Guest>, resources: Resources) : Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.titulo))
        guests.forEach {
            append("<br>")
            append(resources.getString(R.string.name))
            append(resources.getString(R.string.phone))
            append(resources.getString(R.string.email))
        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}
