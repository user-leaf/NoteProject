package com.sesame.codelab.livedata

import androidx.lifecycle.MutableLiveData
import com.sesame.codelab.viewmodel.Person

object SharedLiveData {
    private val list = ArrayList<Person>()

    val personList: MutableLiveData<ArrayList<Person>> by lazy {
        MutableLiveData<ArrayList<Person>>()
    }

    fun addPerson(person: Person){
        list.add(person)
        personList.value = list
    }

    fun clear(){
        list.clear()
        personList.value = list
    }
}