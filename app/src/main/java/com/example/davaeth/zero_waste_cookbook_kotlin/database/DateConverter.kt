package com.example.davaeth.zero_waste_cookbook_kotlin.database

import androidx.room.TypeConverter
import java.util.*

class DateConverter {

    companion object {
        @TypeConverter
        fun toDate(dateLong: Long?): Date? {
            return if (dateLong == null) {
                null;
            } else {
                Date(dateLong)
            }
        }

        @TypeConverter
        fun toLong(date: Date?): Long? = date?.time
    }
}