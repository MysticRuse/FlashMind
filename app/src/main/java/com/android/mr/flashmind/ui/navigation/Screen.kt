package com.android.mr.flashmind.ui.navigation

import java.net.URLEncoder

sealed class Screen(val route: String) {
    object Dashboard : Screen("dashboard")
    object InputSelection : Screen("input_selection")
    object Camera : Screen("camera")
    object ReviewCards : Screen("review_cards/{extractedText}") {
        fun createRoute(text: String) = "review_cards/${URLEncoder.encode(text, "UTF-8")}"
    }
    object Study : Screen("study/{deckId}") {
        fun createRoute(deckId: Long) = "study/$deckId"
    }
    object Results : Screen("results/{deckId}/{score}/{total}") {
        fun createRoute(deckId: Long, score: Int, total: Int) = "results/$deckId/$score/$total"
    }
}