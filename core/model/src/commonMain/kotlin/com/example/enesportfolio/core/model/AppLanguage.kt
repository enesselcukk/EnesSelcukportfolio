package com.example.enesportfolio.core.model

enum class AppLanguage {
    EN,
    TR,
    ;

    companion object {
        fun fromCode(code: String?): AppLanguage =
            when (code?.lowercase()) {
                "tr" -> TR
                else -> EN
            }
    }

    val code: String
        get() = name.lowercase()
}
