package com.uwaisalqadri.shared.domain.base

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesIgnore
import com.uwaisalqadri.shared.data.model.response.ApiException
import com.uwaisalqadri.shared.domain.model.ApiError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlin.coroutines.CoroutineContext

@NativeCoroutinesIgnore
fun <T>execute(
    context: CoroutineContext = Dispatchers.Default,
    block: suspend () -> T
): Flow<T> {
    return flow {
        try {
            val out = block.invoke()
            emit(out)
        } catch (e: ApiException) {
            throw ApiError(e.errors.orEmpty())
        }
        catch (e: Throwable) {
            throw e
        }
    }.flowOn(context)
}