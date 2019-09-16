package dev.alexferreira.external_api

import org.junit.Assert
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class DateFormatTest {

    @Test
    fun createDateFrom_string() {
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssSSSS", Locale.getDefault()).parse("2018-09-11T12:30:19-0300")

        Assert.assertEquals(1536679818700L, date.time)
    }
}