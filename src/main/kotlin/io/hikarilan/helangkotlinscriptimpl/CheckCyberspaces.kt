package io.hikarilan.helangkotlinscriptimpl

import com.google.gson.Gson
import com.google.gson.JsonObject
import java.net.URL

fun cyberspaces() {
    println("Getting your location...")
    CheckCyberspaces.getRegion().let {
        println("Your location is $it.")
        if (it in CheckCyberspaces.AMERICAN_REGIONS) {
            println("Congratulations! You are in the Cyber Spaces!")
        } else {
            println("What a pity! It seems that you are not in the Cyber Spaces.")
        }
    }
}

object CheckCyberspaces {

    val AMERICAN_REGIONS = arrayOf(
        "UNITED STATES",
        "JAPAN"
    )

    fun getRegion(): String {
        URL("https://pv.sohu.com/cityjson?ie=utf-8").openConnection().getInputStream().use {
            val json = it.bufferedReader().readText()
            return Gson().fromJson(
                "{" + json.substringAfter('{').substringBefore('}')+ "}",
                JsonObject::class.java
            )["cname"].asString
        }
    }

}