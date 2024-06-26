package ru.btpit.zadanie2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import ru.btpit.zadanie2.R
import ru.btpit.zadanie2.databinding.ActivityIntentHandlerBinding

class IntentHandlerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_handler)
        val binding = ActivityIntentHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent?.let {
            if (it.action != Intent.ACTION_SEND) {
                return@let
            }

            val text = it.getStringExtra(Intent.EXTRA_TEXT)
            if (text.isNullOrBlank()) {
                Snackbar.make(binding.root, R.string.error_content,
                    BaseTransientBottomBar.LENGTH_INDEFINITE
                )
                    .setAction(android.R.string.ok) {
                        finish()
                    }
                    .show()
                return@let
            }
            // TODO: handle text
        }
    }
}