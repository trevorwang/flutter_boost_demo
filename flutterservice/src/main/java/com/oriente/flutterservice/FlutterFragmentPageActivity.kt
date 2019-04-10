package com.oriente.flutterservice

import android.os.Build
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager
import io.flutter.plugin.platform.PlatformPlugin

class FlutterFragmentPageActivity : AppCompatActivity() {

    private var mFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = 0x40000000
            window.decorView.systemUiVisibility = PlatformPlugin.DEFAULT_SYSTEM_UI
        }
        super.onCreate(savedInstanceState)

        val actionBar = supportActionBar
        actionBar?.hide()

        setContentView(R.layout.flutter_fragment_page)

        mFragment = FlutterFragment.instance("hello")

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_stub, mFragment!!)
            .commit()
    }
}
