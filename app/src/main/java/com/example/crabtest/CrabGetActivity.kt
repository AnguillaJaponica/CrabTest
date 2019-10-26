package com.example.crabtest

import com.amazonaws.mobileconnectors.apigateway.ApiClientFactory;
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.crabtest.gateway.model.CrabTest
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import okhttp3.Interceptor.Companion.invoke
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AlertDialog
import com.example.crabtest.gateway.TestapiforcrabClient

class CrabGetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crab_get)
        Thread(Runnable { invoke() }).start()
    }

    operator fun invoke() {
        val crab_test = CrabTest()
        crab_test.setKey1("みゅーもり");
        crab_test.setKey2("susususu");
        crab_test.setKey3("おくちゃぱんさん");

        val key1 = crab_test.key1;
        val key2 = crab_test.key2;
        val key3 = crab_test.key3;

        // メインスレッドでAlertDialogを表示
        runOnUiThread {
            AlertDialog.Builder(this)
                .setTitle("SDK From AWS APIGateway")
                .setMessage(key1 +"："+ key2 +"："+ key3)
                .setPositiveButton(android.R.string.ok, null)
                .create()
                .show()
        }
    }

}
