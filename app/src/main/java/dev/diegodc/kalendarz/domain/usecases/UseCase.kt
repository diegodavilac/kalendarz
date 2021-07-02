package dev.diegodc.kalendarz.domain.usecases

import kotlinx.coroutines.flow.Flow

interface UseCase<T,R> {
    fun call(params: T) : Flow<R>
}