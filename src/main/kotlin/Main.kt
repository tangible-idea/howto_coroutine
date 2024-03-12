package org.example

import kotlinx.coroutines.*

fun main() = runBlocking {  // CoroutineScope

    val job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // 약간의 시간 동안 delay 한다.
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit.")

}


/**
 *
 */
suspend fun doWorldNormal() = runBlocking {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("doWorldScope!")
}

/**
 * coroutineScope로 함수 빌더로 만들면, 모두 완료될때까지 종료되지 않는다.
 */
suspend fun doWorldScope() = coroutineScope {
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("doWorldScope!")
}
