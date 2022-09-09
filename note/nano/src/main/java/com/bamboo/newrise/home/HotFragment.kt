package com.bamboo.newrise.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_hot.*

class HotFragment(val list: List<String>) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hot, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = HotAdapter(list)
        rvHot.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvHot.adapter = adapter
//        val divider = DividerItemDecoration(context, LinearLayout.VERTICAL)
//        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.custom_divider)!!)

//        val divider = RecycleViewDivider(requireContext(), LinearLayout.HORIZONTAL, R.drawable.custom_divider)
        val divider = RecycleViewDivider(requireContext(), LinearLayout.HORIZONTAL, 10, requireContext().getColor(android.R.color.holo_blue_dark))
        rvHot.addItemDecoration(divider)
    }
}