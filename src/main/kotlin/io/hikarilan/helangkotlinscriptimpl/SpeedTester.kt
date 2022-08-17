package io.hikarilan.helangkotlinscriptimpl

import kotlin.random.Random

object SpeedTester {

    private val MUSICS = arrayOf(
        "Kill You", "Lighters", "ZOOD", "Love the Way You Lie",
        "The Monster", "Numb Encore", "Kinds Never Die", "I Need a Doctor",
        "Lose Yourself", "Mockingbird", "Beautiful", "Not Afraid",
        "Rap God", "Phenomenal", "Stan", "Space Bound", "Stan", "Guts Over Fear",
    )

    private val SUFFIX = arrayOf(
        ".mp3", ".ogg", ".flac"
    )

    private val MUSIC_SIZE_MB_RANGE = Pair(10, 30)

    fun test() {
        println("> Cyber DJ is downloading musics via 5G...")
        MUSICS.toList().shuffled().forEach {
            val fileName = it + SUFFIX.random()
            val fileSize = Random.nextInt(MUSIC_SIZE_MB_RANGE.first, MUSIC_SIZE_MB_RANGE.second)
            println("Downloading $fileName, totally $fileSize MB")
            Thread.sleep(Random.nextLong(1, 25) * fileSize)
            println("| Successfully downloaded $fileName")
        }
        println("> Test finished, 5G is so fast!")
    }
}