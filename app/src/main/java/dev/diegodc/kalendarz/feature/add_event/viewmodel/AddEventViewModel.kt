package dev.diegodc.kalendarz.feature.add_event.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.diegodc.kalendarz.domain.usecases.CreateEventUseCase

@HiltViewModel
class AddEventViewModel(
    private val createEventUseCase: CreateEventUseCase
) : ViewModel() {


}