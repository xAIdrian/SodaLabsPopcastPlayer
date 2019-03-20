package com.androidtitan.sodapopcastplayer

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidtitan.sodapopcastplayer.data.ConstructData
import com.androidtitan.sodapopcastplayer.data.Podcast
import kotlinx.android.synthetic.main.media_player_control.*
import java.io.IOException

class MainActivity : AppCompatActivity(), PodcastFragment.OnListFragmentInteractionListener {

    var mediaPlayer: MediaPlayer? = null
    var podcastInFocus: Podcast? = null

    val podcasts = ConstructData.ITEMS
    var trackingLength: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        back_button.setOnClickListener { podcastInFocus?.let { playPreviousSong(it) } }
        play_pause_button.setOnClickListener { podcastInFocus?.let { playPressed(it) } }
        forward_button.setOnClickListener { podcastInFocus?.let { playNextSong(it) } }
    }

    override fun onListFragmentInteraction(item: Podcast?) {
        item?.let {
            playPressed(it)
        }
    }

    override fun onDestroy() {
        mediaPlayer?.stop()
        super.onDestroy()
    }

    private fun playPressed(podcast: Podcast) {
        if (podcast != podcastInFocus) {
            mediaPlayer?.pause()
            trackingLength = 0
            playSong(podcast)

        } else {
            if(mediaPlayer?.isPlaying == true){
                pauseSong(podcast)
            } else {
                playSong(podcast)
            }
        }
        podcastInFocus = podcast
    }

    private fun playSong(item: Podcast) {
        play_pause_button.setImageDrawable(getDrawable(R.drawable.ic_pause_black_24dp))
        tracking_title.text = item.description

        try {
            mediaPlayer = MediaPlayer.create(this, item.audioFile).apply {
                seekTo(trackingLength!!)
                start()
            }
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        } catch (e: IllegalStateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun pauseSong(item: Podcast) {
        play_pause_button.setImageDrawable(getDrawable(R.drawable.ic_play_arrow_black_24dp))
        mediaPlayer?.pause()
        trackingLength = mediaPlayer?.currentPosition
    }

    private fun playNextSong(item: Podcast) {
        //check for overflow
        var newItem = if (item.indexPosition + 1 >= podcasts.size) {
            podcasts[0]
        } else {
            podcasts[item.indexPosition + 1]
        }

        playPressed(newItem)
    }

    private fun playPreviousSong(item: Podcast) {
        //check for underflow
        mediaPlayer?.pause()
        podcastInFocus = item

        var newItem = if (item.indexPosition - 1 < 0) {
            podcasts[podcasts.size - 1]
        } else {
            podcasts[item.indexPosition - 1]
        }

        playPressed(newItem)
    }
}
