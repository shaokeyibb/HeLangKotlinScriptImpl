package io.hikarilan.helangkotlinscriptimpl

import kotlin.script.experimental.annotations.KotlinScript
import kotlin.script.experimental.api.ScriptCompilationConfiguration
import kotlin.script.experimental.api.defaultImports

@KotlinScript(
    displayName = "He Lang Kotlin Script Implementation",
    fileExtension = "he.kts",
    compilationConfiguration = HeLangKotlinScriptConfiguration::class
)
abstract class HeLangKotlinScript

object HeLangKotlinScriptConfiguration : ScriptCompilationConfiguration({
    defaultImports(
        "io.hikarilan.helangkotlinscriptimpl.createU8",
        "io.hikarilan.helangkotlinscriptimpl.u8",
        "io.hikarilan.helangkotlinscriptimpl.|",
        "io.hikarilan.helangkotlinscriptimpl.test5g",
        "io.hikarilan.helangkotlinscriptimpl.sprint"
    )
})

