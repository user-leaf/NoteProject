package com.sesame.mypuremusic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sesame.mypuremusic.adapter.MyAdapter
import com.sesame.mypuremusic.model.Person
import kotlinx.android.synthetic.main.fragment_main_content.*

class MainContentFragment : Fragment() {

    companion object {
        fun newInstance() = MainContentFragment()
    }

    private lateinit var viewModel: MainContentViewModel
    private lateinit var adapter: MyAdapter
    private val personList = mutableListOf<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_content, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainContentViewModel::class.java)

        initView()
        initData()
    }

    private fun initView() {
        recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        adapter = MyAdapter(context, personList)
        recyclerView.adapter = adapter
    }

    private fun initData() {
        for (item in 0..20) {
            personList.add(Person("$item", 20 + item))
        }
        adapter.notifyDataSetChanged()
    }
}
