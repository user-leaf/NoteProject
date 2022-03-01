package com.sesame.module_test.test_viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sesame.module_test.R
import kotlinx.android.synthetic.main.frg_quotation_list.*

class QuotationListFragment : Fragment() {

    companion object {
        fun instance(title: String): QuotationListFragment {
            val bundle = Bundle()
            bundle.putCharSequence("title", title)
            val fragment = QuotationListFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frg_quotation_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = arguments?.getString("title")?: ""
        tvTitle.text = title
    }
}