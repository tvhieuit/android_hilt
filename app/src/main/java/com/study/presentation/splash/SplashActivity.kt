package com.study.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.study.R
import com.study.network.ApiClient
import com.study.presentation.login.LoginActivity
import com.trello.rxlifecycle4.android.lifecycle.kotlin.bindToLifecycle
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var api: ApiClient

    private val loginNavigation = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.btnTest).setOnClickListener {
            api.testGet("123").subscribe(

            )
        }

    }

    override fun onResume() {
        super.onResume()



        Observable.timer(3, TimeUnit.SECONDS)
            .bindToLifecycle(this)
            .subscribeBy {
                loginNavigation.launch(Intent(this, LoginActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    .addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                )
            }

    }
}