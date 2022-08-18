package io.hikarilan.helangkotlinscriptimpl

import kotlin.random.Random

fun test5g() {
    println("> Cyber DJ is downloading musics via 5G...")
    SpeedTester.MUSICS.toList().shuffled().forEach {
        val fileName = it + SpeedTester.SUFFIX.random()
        val fileSize = Random.nextInt(SpeedTester.MUSIC_SIZE_MB_RANGE.first, SpeedTester.MUSIC_SIZE_MB_RANGE.second)
        println("Downloading $fileName, totally $fileSize MB")
        Thread.sleep(Random.nextLong(1, 25) * fileSize)
        println("| Successfully downloaded $fileName")
    }
    println("> Test finished, 5G is so fast!")
}

object SpeedTester {

    val MUSICS = arrayOf(
        "Kill You", "Lighters", "ZOOD", "Love the Way You Lie",
        "The Monster", "Numb Encore", "Kinds Never Die", "I Need a Doctor",
        "Lose Yourself", "Mockingbird", "Beautiful", "Not Afraid",
        "Rap God", "Phenomenal", "Stan", "Space Bound", "Stan", "Guts Over Fear",
    )

    val SUFFIX = arrayOf(
        ".mp3", ".ogg", ".flac"
    )

    val MUSIC_SIZE_MB_RANGE = Pair(10, 30)
}