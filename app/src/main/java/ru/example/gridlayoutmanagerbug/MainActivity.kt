package ru.example.gridlayoutmanagerbug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.rv

class MainActivity : AppCompatActivity() {

    companion object {
        const val SPAN_COUNT = 4
    }

    private val items = (0..50).map { it.toString() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.adapter = SimpleAdapter().also { it.items = items }

        GridLayoutManager(this, SPAN_COUNT).also {
            rv.layoutManager = it

            it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {

                override fun getSpanSize(position: Int) =
                    if (position == 0) {
                        SPAN_COUNT //full width header in first!! row
                    } else {
                        1
                    }
            }
        }
        rv.requestFocus()
        rv.post { selectLastItem() }

    }

    private fun selectLastItem() {
        val lastItemPosition = rv.adapter!!.itemCount - 1
        rv.scrollToPosition(lastItemPosition)
        rv.post { rv.findViewHolderForAdapterPosition(lastItemPosition)?.itemView?.requestFocus() }
    }

}
