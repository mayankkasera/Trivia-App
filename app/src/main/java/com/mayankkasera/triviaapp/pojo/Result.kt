package com.mayankkasera.triviaapp.pojo

import android.os.Parcelable
import androidx.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.parcel.Parcelize
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList

@Entity
@Parcelize
@TypeConverters(Result.QAConverter::class, Result.DateTimeConverters::class)
data class Result(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var calendar: Calendar,
    var name : String?,
    var list : ArrayList<QA>?
) : Parcelable {
    @Parcelize
    data class QA(
        var que : String?,
        var ans : String?
    ) : Parcelable


    class QAConverter{
        @TypeConverter
        fun getQA(data: String?): ArrayList<QA>? {
            val gson = Gson()
            if (data == null) {
                return arrayListOf()
            }
            val listType: Type = object : TypeToken<ArrayList<QA>?>() {}.type
            return gson.fromJson<ArrayList<QA>>(data, listType)
        }

        @TypeConverter
        fun setQA(myObjects: ArrayList<QA>?): String? {
            val gson = Gson()
            return gson.toJson(myObjects)
        }
    }

    class DateTimeConverters {
        @TypeConverter
        fun toCalendar(l: Long): Calendar? {
            val c = Calendar.getInstance()
            c.timeInMillis = l
            return c
        }

        @TypeConverter
        fun fromCalendar(c: Calendar?): Long? {
            return c?.time?.time
        }
    }
}