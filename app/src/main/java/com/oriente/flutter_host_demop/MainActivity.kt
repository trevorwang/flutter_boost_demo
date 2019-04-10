package com.oriente.flutter_host_demop

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.oriente.flutterservice.PageRouter
import java.lang.ref.WeakReference


class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sRef = WeakReference(this)
        setContentView(R.layout.native_page)

        mOpenNative = findViewById(R.id.open_native)
        mOpenFlutter = findViewById(R.id.open_flutter)
        mOpenFlutterFragment = findViewById(R.id.open_flutter_fragment)

        mOpenNative!!.setOnClickListener(this)
        mOpenFlutter!!.setOnClickListener(this)
        mOpenFlutterFragment!!.setOnClickListener(this)

    }

    private var mOpenNative: TextView? = null
    private var mOpenFlutter: TextView? = null
    private var mOpenFlutterFragment: TextView? = null



    override fun onDestroy() {
        super.onDestroy()
        sRef.clear()
    }

    override fun onClick(v: View) {
        if (v === mOpenNative) {
            PageRouter.openPageByUrl(this, PageRouter.NATIVE_PAGE_URL)
        } else if (v === mOpenFlutter) {
            PageRouter.openPageByUrl(this, PageRouter.FLUTTER_PAGE_URL)
        } else if (v === mOpenFlutterFragment) {
            PageRouter.openPageByUrl(this, PageRouter.FLUTTER_FRAGMENT_PAGE_URL)
        }
    }

    companion object {

        var sRef:WeakReference<Activity?> = WeakReference(null)
    }
}
