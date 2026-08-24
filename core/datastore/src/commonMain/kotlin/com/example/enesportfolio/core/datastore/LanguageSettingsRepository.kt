package com.example.enesportfolio.core.datastore

import com.example.enesportfolio.core.model.AppLanguage
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface LanguageSettingsRepository {
    val language: Flow<AppLanguage>

    suspend fun setLanguage(language: AppLanguage)
}

class DefaultLanguageSettingsRepository(
    private val settings: Settings = Settings(),
) : LanguageSettingsRepository {
    private val languageState = MutableStateFlow(readLanguage())

    override val language: Flow<AppLanguage> = languageState.asStateFlow()

    override suspend fun setLanguage(language: AppLanguage) {
        settings[SettingsKeys.LANGUAGE] = language.code
        languageState.value = language
    }

    private fun readLanguage(): AppLanguage =
        AppLanguage.fromCode(settings.getStringOrNull(SettingsKeys.LANGUAGE))
}
