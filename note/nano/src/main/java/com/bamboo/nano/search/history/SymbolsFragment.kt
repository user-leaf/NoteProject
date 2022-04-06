package com.bamboo.nano.search.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bamboo.nano.R
import com.bamboo.nano.search.SearchAdapter
import com.bamboo.nano.search.SearchViewModel
import kotlinx.android.synthetic.main.fragment_search_result.*
import kotlinx.android.synthetic.main.fragment_symbols.*

class SymbolsFragment : Fragment() {

    private val viewModel by activityViewModels<SearchViewModel>()
    private val adapter by lazy {
        SymbolsAdapter()
    }

    companion object {
        fun newInstance(position: String): Fragment {
            val bundle = Bundle()
            bundle.putString("KEY_POSITION", position)
            val fragment = SymbolsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_symbols, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSymbols.layoutManager = LinearLayoutManager(requireContext())
        rvSymbols.adapter = adapter
        viewModel.symbolsLiveData.observe(viewLifecycleOwner) {
            adapter.replaceData(it)
        }
        viewModel.loadDataBySymbol()
    }
}