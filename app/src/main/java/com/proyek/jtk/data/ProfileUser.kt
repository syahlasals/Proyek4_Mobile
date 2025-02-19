package com.proyek.jtk.data

import android.content.Context
import android.net.Uri
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {

    companion object {
        private val PROFILE_IMAGE_KEY = stringPreferencesKey("profile_image_uri")
    }

    // Simpan URI ke DataStore
    suspend fun saveProfileImage(uri: Uri?) {
        context.dataStore.edit { preferences ->
            preferences[PROFILE_IMAGE_KEY] = uri?.toString() ?: ""
        }
    }

    // Ambil URI dari DataStore
    fun getProfileImage(): Flow<Uri?> {
        return context.dataStore.data.map { preferences ->
            preferences[PROFILE_IMAGE_KEY]?.takeIf { it.isNotEmpty() }?.let { Uri.parse(it) }
        }
    }
}