package com.bamboo.nano.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.bamboo.nano.R
import com.bamboo.nano.list.adapter.QuotationAdapter
import com.bamboo.nano.list.model.QuotationModel
import kotlinx.android.synthetic.main.fragment_quotation_list.*

class QuotationListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quotation_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvContent.layoutManager = LinearLayoutManager(context, OrientationHelper.VERTICAL, false)
        rvContent.addItemDecoration(DividerItemDecoration(context, OrientationHelper.VERTICAL))
        val data = getData()
        val adapter = QuotationAdapter(data)
        rvContent.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            if (data[position].type == 0) {
//                (adapter as QuotationAdapter).expandPosition(position)
                adapter.notifyItemChanged(position, "expand")
            }
        }
    }

    private fun getData(): MutableList<QuotationModel> {
        val list = mutableListOf<QuotationModel>()
        for (i in 1..50) {
            list.add(QuotationModel("大标题$i", 0))
            if (i == 3) {
                list.add(QuotationModel("小标题$i-1", 1))
            }
            if (i == 5) {
                list.add(QuotationModel("小标题$i-1", 1))
                list.add(QuotationModel("小标题$i-2", 1))
            }
        }
        return list
    }
}