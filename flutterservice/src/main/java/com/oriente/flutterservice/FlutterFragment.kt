package com.oriente.flutterservice

import android.os.Bundle
import com.taobao.idlefish.flutterboost.containers.BoostFlutterFragment
import io.flutter.plugin.common.PluginRegistry
import io.flutter.plugins.GeneratedPluginRegistrant

import java.util.HashMap

class FlutterFragment : BoostFlutterFragment() {

    override fun setArguments(args: Bundle?) {
        var args2 = args
        if (args2 == null) {
            args2 = Bundle()
            args2.putString("tag", "")
        }
        super.setArguments(args2)
    }

    fun setTabTag(tag: String) {
        val args = Bundle()
        args.putString("tag", tag)
        super.setArguments(args)
    }

    override fun onRegisterPlugins(registry: PluginRegistry) {
        GeneratedPluginRegistrant.registerWith(registry)
    }

    override fun getContainerName(): String {
        return "flutterFragment"
    }

    override fun getContainerParams(): Map<*, *> {
        val params = HashMap<String, String>()
        params["tag"] = arguments.getString("tag")
        return params
    }

    override fun destroyContainer() {

    }

    companion object {

        fun instance(tag: String): FlutterFragment {
            val fragment = FlutterFragment()
            fragment.setTabTag(tag)
            return fragment
        }
    }
}