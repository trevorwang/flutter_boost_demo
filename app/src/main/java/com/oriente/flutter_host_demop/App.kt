package com.oriente.flutter_host_demop

import android.app.Activity
import com.oriente.flutterservice.FlutterServiceApplication

class App : FlutterServiceApplication() {
    override fun getMainActivity(): Activity? {
        return MainActivity.sRef.get()
    }


}