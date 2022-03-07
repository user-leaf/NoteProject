package com.bamboo.nano.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboo.nano.R
import kotlinx.android.synthetic.main.fragment_notice.*

class NoticeFragment : Fragment() {

    private var param: String? = null

    private val noticeAdapter by lazy {
        NoticeAdapter().apply {
            setOnItemClickListener { adapter, view, position ->
                getItem(position)?.let {
                    if (!it.read) {
                        it.read = true
                        notifyItemChanged(position)
                    }
                }
            }
        }
    }

    private val viewModel by lazy {
        NoticeViewModel()
    }

    companion object {
        fun newInstance(param: String): Fragment {
            val fragment = NoticeFragment()
            fragment.arguments = Bundle().apply {
                putString("param", param)
            }
            return fragment
        }

        fun newInstance2(param: String) = NoticeFragment().apply {
            arguments = Bundle().apply {
                putString("param", param)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notice, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = noticeAdapter
        viewModel.data.observe(viewLifecycleOwner) {
            noticeAdapter.setNewData(it)
        }
        viewModel.loadData()
    }
}