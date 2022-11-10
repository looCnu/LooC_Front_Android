package com.example.looc.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.looc.R

class ProgressBarActivity : AppCompatActivity() {
    var isStarted = false
    var secondaryHandler: Handler? = Handler()
    var primaryProgressStatus = 0
    var secondaryProgressStatus = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_bar)




        primaryProgressStatus = 0
        secondaryProgressStatus = 0

        Thread(Runnable {
            while (primaryProgressStatus < 100) {
                primaryProgressStatus += 1

                try {
                    Thread.sleep(500)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                startSecondaryProgress()
                secondaryProgressStatus = 0

                val textViewPrimary = findViewById<TextView>(R.id.textViewPrimary)
                secondaryHandler?.post {
                    findViewById<ProgressBar>(R.id.progressBarSecondary).progress =
                        primaryProgressStatus
                    textViewPrimary.text = "Complete $primaryProgressStatus%"

                    if (primaryProgressStatus == 100) {
                        textViewPrimary.text = "All tasks completed"
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }).start()


    }

    fun startSecondaryProgress() {
        Thread(Runnable {
            while (secondaryProgressStatus < 100) {
                secondaryProgressStatus += 1

                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                secondaryHandler?.post {
                    findViewById<ProgressBar>(R.id.progressBarSecondary).setSecondaryProgress(
                        secondaryProgressStatus
                    )
                    //findViewById<TextView>(R.id.textViewSecondary).setText("Current task progress\n$secondaryProgressStatus% of 100")
                    findViewById<TextView>(R.id.textViewSecondary).setText("좋아할 만한 강의를 찾고 있어요..!")
                    if (secondaryProgressStatus == 100) {
                        findViewById<TextView>(R.id.textViewSecondary).setText("좋아할 만한 강의를 찾고 있어요...")
                    }
                }
            }
        }).start()
    }

    fun horizontalDeterminate(view: View) {
        isStarted = !isStarted
    }
}