package com.example.fifthapplicaion


import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var player: MediaPlayer

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        player = MediaPlayer.create(context, R.raw.bellsound)
        player.isLooping = true

        playButton.setOnClickListener { player.start() }
        pauseButton.setOnClickListener { player.pause() }
        stopButton.setOnClickListener { player.stop() }
    }
}
