package com.cafermertceyhan.smsuserconsentapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.phone.SmsRetriever

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startSmsUserConsent()
    }

    private fun startSmsUserConsent() {
        SmsRetriever.getClient(this).also {
            //We can add user phone number or leave it blank
            it.startSmsUserConsent(null)
                    .addOnSuccessListener {
                        Log.d(TAG, "LISTENING_SUCCESS")
                    }
                    .addOnFailureListener {
                        Log.d(TAG, "LISTENING_FAILURE")
                    }
        }
    }

    companion object {
        const val TAG = "SMS_USER_CONSENT"
    }
}
