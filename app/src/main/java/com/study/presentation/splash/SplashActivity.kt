package com.study.presentation.splash

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.study.R
import com.study.network.ApiClient
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var api: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.btnTest).setOnClickListener {
            api.testGet("123").subscribe(

            )
        }
    }
}