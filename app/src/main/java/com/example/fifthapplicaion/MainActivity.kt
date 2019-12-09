package com.example.fifthapplicaion

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var player: MediaPlayer

    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> {
                    return MainFragment()
                }
                else -> {
                    return SubFragment()
                }
            }
        }

        override fun getCount(): Int {
            return 2
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pager.adapter = MyAdapter(supportFragmentManager)

        player = MediaPlayer.create(this, R.raw.bellsound)
        player.isLooping = true
    }
}

