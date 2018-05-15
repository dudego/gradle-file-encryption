package com.example.gradlefileencryption

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.gradlefileencryption.utilities.encryption.EncryptionHelper
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val responseStr = readFromAsset(this, BuildConfig.ENC_FILE)
        val data = EncryptionHelper.getDecryptedString(responseStr)
        this.text2.text = data
    }

    fun readFromAsset(context: Context, fileName: String): String? {
        var json: String?
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            return null
        }

        return json
    }
}
