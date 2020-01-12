package com.kyanro.okoraredaggerdrill.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kyanro.okoraredaggerdrill.domain.fortune.FortuneTextCreator

class HomeSecondViewModel(
    private val fortuneTextCreator: FortuneTextCreator
) : ViewModel() {

    private val _text = MutableLiveData<String>(fortuneTextCreator.fortuneText())
    val text: LiveData<String> = _text
}

@Suppress("UNCHECKED_CAST")
class HomeSecondViewModelFactory(
    private val fortuneTextCreator: FortuneTextCreator
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeSecondViewModel(fortuneTextCreator) as T
    }
}