package com.bamboo.nano.search_copy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bamboo.nano.databinding.FragmentSearch2ResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentSearch2ResultBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance(): ResultFragment {
            val args = Bundle()
            val fragment = ResultFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearch2ResultBinding.inflate(inflater, container, false)
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