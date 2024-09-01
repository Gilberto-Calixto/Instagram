package co.tiagoaguiar.course.instagram.view.common

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import co.tiagoaguiar.course.instagram.R

class CustomDialog(context: Context): Dialog(context) {

    private lateinit var dialogLayout: LinearLayout
    private lateinit var textButtons: Array<TextView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)

        dialogLayout = findViewById(R.id.dialog_container)

    }


    fun addButton( vararg itens: Int, listener: View.OnClickListener) {
        textButtons = Array(itens.size) {
            TextView(context)
        }

        itens.forEachIndexed { index, textId ->
            textButtons[index].id = textId
            textButtons[index].setText(textId)
            textButtons[index].setOnClickListener {
                listener.onClick(it)
                dismiss()
            }
        }
    }

    override fun show() {
        super.show()

        for (textView in textButtons) {
            val layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            layoutParams.setMargins(30, 50, 30, 50)


            dialogLayout.addView(textView, layoutParams)
        }
    }
}