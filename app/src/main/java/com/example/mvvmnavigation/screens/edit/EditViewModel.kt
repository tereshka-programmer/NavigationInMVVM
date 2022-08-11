package com.example.mvvmnavigation.screens.edit

import androidx.lifecycle.MutableLiveData
import com.example.mvvmnavigation.Event
import com.example.mvvmnavigation.R
import com.example.mvvmnavigation.navigator.Navigator
import com.example.mvvmnavigation.screens.base.BaseViewModel

class EditViewModel(
    private val navigator: Navigator,
    screen: EditFragment.Screen
) : BaseViewModel(){

    private val _initialMessageEvent = MutableLiveData<Event<String>>()
    val intitialMessageEvent = _initialMessageEvent

    init {
        _initialMessageEvent.value = Event(screen.initialValue)
    }

    fun onSavePressed(message: String){
        if (message.isBlank()){
            navigator.toast(R.string.empty_message)
            return
        }
        navigator.goBack(message)
    }

    fun onCancelPressed() {
        navigator.goBack()
    }
}