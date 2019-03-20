package com.androidtitan.sodapopcastplayer.data

import androidx.annotation.RawRes
import com.androidtitan.sodapopcastplayer.R
import java.util.ArrayList
import java.util.HashMap

object ConstructData {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<Podcast> = ArrayList()


    init {
        addItem(
                createPodcast(
                        "Brexit A Guide For The Perplexed",
                        "Could Brexit Change Our Travel Plans?",
                        R.raw.brexitguidefortheperflexed_travel)
        )
        addItem(
                createPodcast(
                        "Brexit A Guide For The Perplexed",
                        "Can Scotland Do Brexit Differently",
                        R.raw.brexitguidefortheperflexed_scotland)
        )
        addItem(
                createPodcast(
                        "Flintoff Savage and the Ping Pong Guy",
                        "Preview Flintoff Diving Have You NO Self Respect",
                        R.raw.flintoffsavageandthepingpongguy_preview)
        )
        addItem(
                createPodcast(
                        "Flintoff Savage and the Ping Pong Guy",
                        "Smells Like Team Spirit",
                        R.raw.flintoffsavageandthepingpongguy_smellsliketeenspirit)
        )
        addItem(
                createPodcast(
                        "Intrigue Murder In The Lucky Holiday Hotel",
                        "Murder In The Lucky Holiday Hotel",
                        R.raw.intrigueandmurderintheluckyhotel)
        )
        addItem(
                createPodcast(
                        "The Listening Project",
                        "Christmas Day Omnibus",
                        R.raw.thelisteningproject_omnibuschristmasday)
        )
        addItem(
                createPodcast(
                        "The Listening Project",
                        "Omnibus Jo and Andy Divorce",
                        R.raw.thelisteningproject_ombinusjoyandandydivorce)
        )
        addItem(
                createPodcast(
                        "The Listening Project",
                        "Omnibus Contending With Death",
                        R.raw.thelisteningproject_omnibuscontendingwithdeath)
        )
    }

    /**
     * additional functionality to be added
     */
    private fun addItem(item: Podcast) {
        ITEMS.add(item)
    }

    private fun createPodcast(title: String, description: String, @RawRes mp3: Int): Podcast {
        return Podcast(
                title,
                description,
                mp3
        )
    }
}
