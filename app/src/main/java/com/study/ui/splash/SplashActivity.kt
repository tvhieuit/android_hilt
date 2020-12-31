package com.study.ui.splash

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.study.R
import com.study.network.NetworkTest
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject lateinit var test : NetworkTest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.btnTest).setOnClickListener {
            println("HieuTV : ${test.greeting()}")
        }
    }
}