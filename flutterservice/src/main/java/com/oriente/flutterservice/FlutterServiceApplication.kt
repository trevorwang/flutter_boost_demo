package com.oriente.flutterservice

import android.app.Application
import android.content.Context
import com.taobao.idlefish.flutterboost.FlutterBoostPlugin
import com.taobao.idlefish.flutterboost.interfaces.IPlatform
import io.flutter.app.FlutterApplication

abstract class FlutterServiceApplication : FlutterApplication(), IPlatform {

    override fun onCreate() {
        super.onCreate()
        FlutterBoostPlugin.init(this)
    }

    override fun getApplication(): Application {
        return this
    }

    override fun isDebug(): Boolean {
        return true
    }

    override fun startActivity(context: Context, url: String, requestCode: Int): Boolean {
        return PageRouter.openPageByUrl(context, url, requestCode)
    }

    override fun getSettings(): Map<*, *>? {
        return null
    }
}
