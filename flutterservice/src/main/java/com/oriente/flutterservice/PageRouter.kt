package com.oriente.flutterservice

import android.content.Context
import android.content.Intent
import android.text.TextUtils

object PageRouter {

    const val NATIVE_PAGE_URL = "sample://nativePage"
    const val FLUTTER_PAGE_URL = "sample://flutterPage"
    const val FLUTTER_FRAGMENT_PAGE_URL = "sample://flutterFragmentPage"

    fun openPageByUrl(context: Context, url: String): Boolean {
        return openPageByUrl(context, url, 0)
    }

    fun openPageByUrl(context: Context, url: String, requestCode: Int): Boolean {
        try {
            return when {
                TextUtils.equals(url, FLUTTER_PAGE_URL) -> {
                    context.startActivity(Intent(context, FlutterPageActivity::class.java))
                    true
                }
                TextUtils.equals(url, FLUTTER_FRAGMENT_PAGE_URL) -> {
                    context.startActivity(Intent(context, FlutterFragmentPageActivity::class.java))
                    true
                }
                TextUtils.equals(url, NATIVE_PAGE_URL) -> {
                    context.startActivity(Intent(context, NativePageActivity::class.java))
                    true
                }
                else -> {
                    val intent = Intent(context, FlutterPageActivity::class.java)
                    intent.putExtra("url", url)
                    context.startActivity(intent)
                    true
                }
            }
        } catch (t: Throwable) {
            return false
        }

    }
}
