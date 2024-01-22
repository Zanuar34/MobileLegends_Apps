package com.example.mysimpleandroidproject

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero(
    var heroName : String,
    var role: String,
    var photo : Int,
    var storyHero : String
): Parcelable
