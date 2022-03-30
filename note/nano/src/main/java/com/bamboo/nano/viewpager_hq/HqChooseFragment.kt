package com.bamboo.nano.viewpager_hq

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_hq_choose.*


class HqChooseFragment(private val position: Int) : Fragment() {

    private val TAG: String = HqChooseFragment::class.java.simpleName

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hq_choose, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rbtnChoose.setOnCheckedChangeListener { button, isChecked ->
            (activity as HqChooseActivity).setChecked(position)
            Log.d(TAG, "onViewCreated position: $position")
        }

        if (position == 1) {
            setChecked(true)
        }
    }

    fun setChecked(isChecked: Boolean) {
        rbtnChoose.setOnCheckedChangeListener(null)
        rbtnChoose.isChecked = isChecked
        rbtnChoose.setOnCheckedChangeListener { button, isChecked ->
            (activity as HqChooseActivity).setChecked(position)
            Log.d(TAG, "setChecked position: $position")
        }
    }

    fun getPosition(): Int {
        return position
    }
}