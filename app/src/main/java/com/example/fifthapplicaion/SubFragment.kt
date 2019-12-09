package com.example.fifthapplicaion


import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_sub.*

class SubFragment : Fragment() {

    private lateinit var soundPool: SoundPool
    private var systemSound = 0
    private var chimeSound = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sub, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        playSystemButton.setOnClickListener {
            soundPool.play(systemSound, 1.0f, 1.0f, 0, 0, 1.0f)
        }

        playChimeButton.setOnClickListener {
            soundPool.play(chimeSound, 1.0f, 1.0f, 0, 0, 1.0f)
        }
    }

    override fun onResume() {
        super.onResume()
        soundPool =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                @Suppress("DEPRECATION")
                SoundPool(2, AudioManager.STREAM_ALARM, 0)
            } else {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()
            }
        systemSound = soundPool.load(context, R.raw.se_maoudamashii_system49, 1)
        chimeSound = soundPool.load(context, R.raw.se_maoudamashii_chime12, 1)
    }

    override fun onPause() {
        super.onPause()
        soundPool.release()
    }
}
