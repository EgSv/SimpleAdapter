package ru.startandroid.develop.simpleadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.SimpleAdapter

const val ATTRIBUTE_NAME_TEXT = "text"
const val ATTRIBUTE_NAME_CHECKED = "checked"
const val ATTRIBUTE_NAME_IMAGE = "image"

class MainActivity : AppCompatActivity() {

    private var lvSimple:ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val texts = arrayOf("sometext 1", "sometext 2", "sometext 3",
            "sometext 4", "sometext 5")
        val checked = booleanArrayOf(true, false, false, true, false)
        val img:Int = R.drawable.ic_baseline_two_wheeler_24

        val data = ArrayList<Map<String, Any?>>(texts.size)
        var m:MutableMap<String, Any>?
        for (i in texts.indices) {
            m = HashMap()
            m.put(ATTRIBUTE_NAME_TEXT, texts[i])
            m.put(ATTRIBUTE_NAME_CHECKED, checked[i])
            m.put(ATTRIBUTE_NAME_IMAGE, img)
            data.add(m)
        }

        val from = arrayOf(ATTRIBUTE_NAME_TEXT,
            ATTRIBUTE_NAME_CHECKED,
            ATTRIBUTE_NAME_IMAGE)

        val to = intArrayOf(R.id.tvText, R.id.cbChecked, R.id.ivImg)

        val sAdapter = SimpleAdapter(this, data, R.layout.item,
            from, to)

        lvSimple = findViewById<View>(R.id.lvSimple) as ListView
        lvSimple!!.adapter = sAdapter
    }
}