package dev.alexferreira.data.source.database.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson

object ListConverters {

    @TypeConverter
    @JvmStatic
    fun fromJson(json: String?): List<String> {
        if (json == null) {
            return ArrayList()
        }

        return Gson().fromJson<List<String>>(json, List::class.java)
    }

    @TypeConverter
    @JvmStatic
    fun toJson(list: List<String>?): String {
        if (list == null) {
            return ""
        }

        return Gson().toJson(list)
    }
}