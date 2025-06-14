package com.app.presentation.navigation


sealed class Navigation(val destination: String) {
    data object Main : Navigation("main")
}
