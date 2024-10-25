package com.example.fragmentnavigation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SettingsViewModel(application: Application) : AndroidViewModel(application) {

    private val prefs = application.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    private val DARK_MODE_KEY = "dark_mode"

    // LiveData to store userName
    private val _userName = MutableLiveData<String>()
    // Exposing the userName to LiveData
    val userName: LiveData<String> get() = _userName

    private val _isDarkMode = MutableLiveData<Boolean>()
    val isDarkMode: LiveData<Boolean> = _isDarkMode

    init {
        _isDarkMode.value = prefs.getBoolean(DARK_MODE_KEY, false)
    }

    // Method to update userName
    fun setUserName(name: String) {
        _userName.value = name
    }

    fun toggleDarkMode(isDark: Boolean) {
        _isDarkMode.value = isDark
        prefs.edit().putBoolean(DARK_MODE_KEY, isDark).apply()
    }
}