package com.jarvisx.data

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

object SecureVault {
    fun put(context: Context, key: String, value: String) {
        val prefs = prefs(context)
        prefs.edit().putString(key, value).apply()
    }

    fun get(context: Context, key: String): String? = prefs(context).getString(key, null)

    private fun prefs(context: Context) =
        EncryptedSharedPreferences.create(
            context,
            "jarvisx.secure",
            MasterKey.Builder(context).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
}