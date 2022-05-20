package com.bamboo.nano.search_copy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bamboo.nano.databinding.FragmentSearch2HistoryBinding

class HistoryFragment : Fragment() {

    private var _binding: FragmentSearch2HistoryBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): HistoryFragment {
            val args = Bundle()
            val fragment = HistoryFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearch2HistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}