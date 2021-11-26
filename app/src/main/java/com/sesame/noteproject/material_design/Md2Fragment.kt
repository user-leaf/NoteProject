package com.sesame.noteproject.material_design

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sesame.noteproject.R

class Md2Fragment: Fragment() {

    companion object{
        fun newInstance(): Md2Fragment {
            val fragment = Md2Fragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_material_design_2, container, false)
    }
}