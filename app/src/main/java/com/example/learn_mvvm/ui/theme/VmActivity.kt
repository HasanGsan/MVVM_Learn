package com.example.learn_mvvm.ui.theme

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VmActivity : ViewModel() {

    var svLiveData = MutableLiveData<String>()
    private var svSaveText: String? = null

    init{
        Log.e("AAA", "View Model создана")
    }

    override fun onCleared() {
        Log.e("AAA", "View Model очищена")
        super.onCleared()
    }

    fun getResultLiveData(): LiveData<String>{ // Некая защита от изменений в главной активности
        return svLiveData
    }

    fun save(text: String){
        svSaveText = text
        svLiveData.value = text
    }

    fun load() {
        svLiveData.value = svSaveText.toString()
    }



}