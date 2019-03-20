package com.androidtitan.sodapopcastplayer.data


data class Podcast(
        val title: String,
        val description: String,
        val audioFile: Int,
        var indexPosition: Int = -1)