package com.oriente.flutterservice

import android.os.Bundle
import com.taobao.idlefish.flutterboost.containers.BoostFlutterActivity
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugins.GeneratedPluginRegistrant

class FlutterPageActivity : BoostFlutterActivity() {
    var url: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        url = intent.getStringExtra("url")

    }

    override fun onRegisterPlugins(registry: PluginRegistry) {
        GeneratedPluginRegistrant.registerWith(registry)
    }

    override fun getContainerName(): String {
        return url ?: "tab"
    }

    override fun getContainerParams(): Map<*, *>? {
        return null
    }


}
