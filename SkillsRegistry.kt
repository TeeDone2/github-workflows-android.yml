package com.jarvisx.engine

/**
 * Register skills accessible via Python-like commands:
 * JarvisX.learn("Supabase Edge Functions")
 * JarvisX.execute("Post AI video to Instagram with caption")
 */
object SkillsRegistry {
    private val skills = mutableMapOf<String, suspend (Map<String,Any?>) -> Any?>()

    fun register(name: String, impl: suspend (Map<String,Any?>)->Any?) {
        skills[name.lowercase()] = impl
    }

    suspend fun call(name: String, args: Map<String,Any?> = emptyMap()): Any? {
        val fn = skills[name.lowercase()] ?: error("Skill not found: $name")
        return fn(args)
    }
}