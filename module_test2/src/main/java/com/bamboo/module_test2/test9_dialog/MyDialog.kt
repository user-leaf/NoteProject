package com.bamboo.module_test2.test9_dialog

import android.app.Dialog
import android.content.res.Resources
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bamboo.module_test2.R

class MyDialog: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val alertDialog = android.app.AlertDialog.Builder(requireContext())
        alertDialog.setView(R.layout.dialog_test9)

//        val dialog2 = Dialog(requireContext(), R.style.AlertDialogStyle)
//        dialog2.setContentView(R.layout.dialog_test9)
//        dialog2.init()
        return alertDialog.create()
    }

    private fun Dialog.init() {
        setCanceledOnTouchOutside(true)
        window?.run {
            setGravity(Gravity.CENTER)
            val wl = attributes
            wl.width = getScreenShorterDimen() * 4 / 5
            wl.height = ViewGroup.LayoutParams.WRAP_CONTENT
            onWindowAttributesChanged(wl)
        }
    }

    fun getScreenShorterDimen(): Int {
        val shortDimen: Int
        val displayMetrics = Resources.getSystem().displayMetrics
        val screenHeight = displayMetrics.heightPixels
        val screenWidth = displayMetrics.widthPixels
        shortDimen = Math.min(screenHeight, screenWidth)
        return shortDimen
    }
}