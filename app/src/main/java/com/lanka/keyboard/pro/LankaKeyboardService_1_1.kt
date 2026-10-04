
package com.lanka.keyboard.pro
import android.inputmethodservice.InputMethodService
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient

class LankaKeyboardService : InputMethodService() {

    inner class KeyboardBridge {
        @JavascriptInterface
        fun commitText(text: String) {
            currentInputConnection?.commitText(text, 1)
        }
        @JavascriptInterface
        fun deleteText() {
            currentInputConnection?.deleteSurroundingText(1, 0)
        }
        @JavascriptInterface
        fun sendEnter() {
            currentInputConnection?.commitText("\n", 1)
        }
    }

    override fun onCreateInputView(): View {
        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = true
        webView.addJavascriptInterface(KeyboardBridge(), "AndroidKeyboard")
        webView.webViewClient = WebViewClient()
        // ඔයාගේ Pro HTML එක මෙතන Load වෙනවා
        webView.loadUrl("file:///android_asset/keyboard.html")
        return webView
    }
}
