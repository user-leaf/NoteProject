package com.bamboo.module_test2.test17_jump2app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bamboo.module_test2.R
import kotlinx.android.synthetic.main.activity_test17_jump_to_app.*

class Test17Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test17_jump_to_app)

        btnLine.setOnClickListener {
            val pkgName = "jp.naver.line.android"
            if (!PackageUtils.checkInstalled(this,pkgName)){
                Toast.makeText(this, "未安装LINE", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            val line = "https://line.me/R/ti/p/@794axtzq"
//            val url = "https://www.baidu.com/abc"
//            val uri = Uri.parse(line)
//
//            println("scheme: ${uri.scheme}")
//            println("host: ${uri.host}")
//            println("path: ${uri.path}")
//            println("pathSegments: ${uri.pathSegments}")
//
//
//            val intent2 = Intent(Intent.ACTION_VIEW)
//            Uri.parse("")
//
//
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(line))
//            startActivity(intent)

//            val url = "https://line.me/R/ti/p/@794axtzq"
//            println("url:$url")
//
//            val intent = Intent(Intent.ACTION_VIEW)
//            val uri = Uri.parse(url)
//            intent.data = uri
//            startActivity(intent)

//            val packageName="jp.naver.line.android"
//            val className="jp.naver.line.android.activity.SplashActivity"
//            val intent = Intent()
//            intent.setClassName(packageName, className)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            println("scheme:${intent.scheme}")
//            startActivity(intent)

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data =
                Uri.parse("https://line.me/R/ti/p/@794axtzq") //@oakmega
            intent.setPackage("jp.naver.line.android")
            startActivity(intent)
        }

        // google.com search: Android open telegram
        // https://stackoverflow.com/questions/61935761/android-open-telegram-specific-account-from-my-own-android-app
        btnTelegram.setOnClickListener {
            val pkgName = "org.telegram.messenger"
            if (!PackageUtils.checkInstalled(this,pkgName)){
                Toast.makeText(this, "未安装Telegram", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                val telegramIntent = Intent(Intent.ACTION_VIEW)
                telegramIntent.data = Uri.parse("https://t.me/t201809")
//                telegramIntent.data = Uri.parse("tg://openmessage?user_id=t201809")
                telegramIntent.setPackage(pkgName)
                startActivity(telegramIntent)
            } catch (e: Exception) {
                // show error message
            }
        }

        btnWhatsapp.setOnClickListener {
            val pkgName = "com.whatsapp"
            if (!PackageUtils.checkInstalled(this,pkgName)){
                Toast.makeText(this, "未安装WhatsApp", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            try {
                val trimToNumner = "+989180074693"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://wa.me/$trimToNumner/?text=")
                startActivity(intent)
            } catch (e: java.lang.Exception) {
            }
        }
    }
}