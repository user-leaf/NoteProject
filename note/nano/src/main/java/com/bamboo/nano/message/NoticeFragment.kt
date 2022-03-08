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

    companion object {
        const val TYPE_NOTICE = 0
        const val TYPE_MESSAGE = 1

        fun newInstance(type: Int): Fragment {
            val fragment = NoticeFragment()
            fragment.arguments = Bundle().apply { // 如果不会用就先不用，或者只用自己熟悉的let
                putInt("type", type)
            }
            return fragment
        }
    }

    private val isNotice by lazy { arguments?.getInt("type") == TYPE_NOTICE }

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

    private val messageAdapter = MessageAdapter()

    private val viewModel by lazy {
        NoticeViewModel()
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
        refreshLayout.setOnLoadMoreListener {
            viewModel.loadData(isNotice, viewModel.page)
        }

        refreshLayout.setOnRefreshListener {
            viewModel.loadData(isNotice, 0)
        }

        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = noticeAdapter
        viewModel.noticeDataLiveData.observe(viewLifecycleOwner) {
            noticeAdapter.setNewData(it)
        }
        viewModel.loadData(isNotice, 0)
    }
}