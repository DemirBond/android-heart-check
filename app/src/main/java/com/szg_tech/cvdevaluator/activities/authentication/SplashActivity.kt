package com.szg_tech.cvdevaluator.activities.authentication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.firestak.lib.utils.threadpool.Coroutines
import com.szg_tech.cvdevaluator.R
import com.szg_tech.cvdevaluator.activities.main.MainActivity
import com.szg_tech.cvdevaluator.rest.requests.LoginCall
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.delay

/**
 * Created by superlight on 7/22/2017 AD.
 */

class SplashActivity : AppCompatActivity() {
    private var flagMain = 0
    private var flagAuth = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        startAnimation()

        Log.e("status", "onCreate")

        LoginCall().tryLogin(this, object : LoginCall.OnLogin {
            override fun onSuccess() {
                Log.e(TAG, "loginCall: Success")
                flagMain++
                goToMainActivity()
            }

            override fun onFailed() {
                Log.e(TAG, "loginCall: Fail")
                flagAuth++
                goToAuthActivity()
            }
        })
    }

    private fun goToAuthActivity() {
        if (flagAuth < 2) return
        Log.e("status", "goto Auth")
        Coroutines.main {
            delay(500)
            startActivity(Intent(applicationContext, AuthenticationActivity::class.java))
            finish()
        }
    }

    private fun goToMainActivity() {
        if (flagMain < 2) return
        Log.e("status", "goto Main")
        Coroutines.main {
            delay(500)
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private fun startAnimation() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.alpha)
        anim.reset()
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {
            }

            override fun onAnimationStart(animation: Animation?) {
            }

            override fun onAnimationEnd(animation: Animation) {
                flagAuth++
                if (flagAuth >= 2) {
                    goToAuthActivity()
                } else {
                    flagMain++
                    if (flagMain >= 2) {
                        goToMainActivity()
                    }
                }
            }
        })
        iv_logo.clearAnimation()
        iv_logo.startAnimation(anim)
    }

    companion object {
        private const val TAG = "SplashActivity"
    }

}
