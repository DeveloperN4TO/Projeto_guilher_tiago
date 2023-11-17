package com.example.canutoapp.utils

import android.content.Context
import android.graphics.Typeface
import android.text.InputFilter
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.ColorInt
import com.google.android.material.textfield.TextInputEditText

fun CharSequence.colorizeText(
    textPartToColorize: CharSequence,
    @ColorInt color: Int
): CharSequence = SpannableString(this).apply {
    try {
        val startIndexOfText = this.indexOf(textPartToColorize.toString())
        val styleSpan = StyleSpan(Typeface.BOLD)
        setSpan(styleSpan, startIndexOfText, startIndexOfText.plus(textPartToColorize.length), 0)
        setSpan(ForegroundColorSpan(color), startIndexOfText, startIndexOfText.plus(textPartToColorize.length), 0)
    } catch (e: Exception) {
        Log.d("exception", e.message.toString())
    }
}

fun TextInputEditText.blockBreakLine(context: Context) = this.apply {
    filters = arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
        if (source != null) {
            val s = source.toString()
            if (s.contains("\n")) {
                // Hide soft keyboard
                val imm: InputMethodManager? = (context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
                imm?.hideSoftInputFromWindow(this.windowToken, 0)
                this.clearFocus()
                return@InputFilter s.replace("\n".toRegex(), "")
            }
        }
        null
    })
}

fun CharSequence.clickableSpan(
    firstText: String,
    firstListener: () -> Unit,
    secondText: String,
    secondListener: () -> Unit
): CharSequence = SpannableString(this).apply {
    try {
        val startIndexOfText = this.indexOf(firstText)
        val secondIndexOfText = this.indexOf(secondText)
        val firstClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                firstListener()
            }
        }
        val secondClickableSpan = object : ClickableSpan() {
            override fun onClick(p0: View) {
                secondListener.invoke()
            }
        }
        setSpan(firstClickableSpan, startIndexOfText, startIndexOfText.plus(firstText.length), 0)
        setSpan(secondClickableSpan, secondIndexOfText, secondIndexOfText.plus(secondText.length), 0)

    } catch (e: Exception) {
        Log.d("exception", e.message.toString())
    }
}

inline fun ifNotNull(a: String?, b: String?, c: String?, d: String?, code: (String, String, String, String) -> Unit?, nullListener: () -> Unit) {
    if (!a.isNullOrEmpty() && !b.isNullOrEmpty() && !c.isNullOrEmpty() && !d.isNullOrEmpty()) {
        code(a, b, c, d)
    } else {
        nullListener.invoke()
    }
}