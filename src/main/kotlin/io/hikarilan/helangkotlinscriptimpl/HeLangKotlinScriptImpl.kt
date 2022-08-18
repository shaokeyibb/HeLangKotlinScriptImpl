@file:Suppress("DANGEROUS_CHARACTERS")

package io.hikarilan.helangkotlinscriptimpl

import java.io.File
import kotlin.script.experimental.api.EvaluationResult
import kotlin.script.experimental.api.ResultWithDiagnostics
import kotlin.script.experimental.api.ScriptDiagnostic
import kotlin.script.experimental.host.toScriptSource
import kotlin.script.experimental.jvmhost.BasicJvmScriptingHost
import kotlin.script.experimental.jvmhost.createJvmCompilationConfigurationFromTemplate

infix fun Int.`|`(other: Int): u8 = u8(0).apply {
    this.list.add(this@`|`)
    this.list.add(other)
}

infix fun u8.`|`(other: Int): u8 = this.apply { list.add(other) }

class u8 private constructor(val list: MutableList<Int> = mutableListOf()) {

    constructor(size: Int) : this(list = MutableList(size) { 0 })

    operator fun set(index: Int, value: Int) {
        if (index == 0) {
            repeat(list.size) { list[it] = value }
            return
        }
        list[index - 1] = value
    }

    operator fun set(index: u8, value: Int) {
        index.list.forEach { this[it] = value }
    }

    operator fun get(index: Int): Int {
        return this.list[index - 1]
    }

    operator fun get(index: u8): u8 {
        return createU8(0).apply { index.list.forEach { list.add(this@u8[it]) } }
    }

    operator fun inc(): u8 {
        return this + 1
    }

    operator fun dec(): u8 {
        return this - 1
    }

    operator fun plus(i: Int): u8 {
        return u8(this.list.map { it + i }.toMutableList())
    }

    operator fun minus(i: Int): u8 {
        return u8(this.list.map { it - i }.toMutableList())
    }

    override fun toString(): String {
        return list.toString()
    }

    override fun hashCode(): Int {
        return list.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return list == other
    }

}

fun createU8(size: Int): u8 = u8(size)

fun sprint(u8: u8) {
    println(u8.list.map { Char(it) }.joinToString(separator = "") { it.toString() })
}

fun evalFile(scriptFile: File): ResultWithDiagnostics<EvaluationResult> {
    val compilationConfiguration = createJvmCompilationConfigurationFromTemplate<HeLangKotlinScript>()
    return BasicJvmScriptingHost().eval(scriptFile.toScriptSource(), compilationConfiguration, null)
}

fun main(vararg args: String) {
    if (args.isEmpty()) {
        println("usage: <app> <he lang script file> [-debug]")
        return
    }

    val result = evalFile(File(args[0]))

    if (args.contains("-debug"))
        result.reports.forEach {
            if (it.severity > ScriptDiagnostic.Severity.DEBUG) {
                println(" : ${it.message}" + if (it.exception == null) "" else ": ${it.exception}")
            }
        }
}