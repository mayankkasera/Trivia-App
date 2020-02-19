package com.mayankkasera.triviaapp.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    var date : Long?,
    var name : String?,
    var list : ArrayList<QA>?
) : Parcelable {
    @Parcelize
    data class QA(
        var que : String?,
        var ans : String?
    ) : Parcelable
}