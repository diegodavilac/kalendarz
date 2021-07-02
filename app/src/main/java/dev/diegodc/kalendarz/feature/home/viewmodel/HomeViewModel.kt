package dev.diegodc.kalendarz.feature.home.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.diegodc.kalendarz.domain.entities.EventEntity
import dev.diegodc.kalendarz.domain.usecases.GetEventsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {

    val events : MutableLiveData<List<EventEntity>> = MutableLiveData()

    fun getEvents(day: Date){
        viewModelScope.launch {
           getEventsUseCase.call(day).collect {
               Log.d("HomeViewModel", "Events : ${it.size}")
               events.value = it
           }
        }
    }
}