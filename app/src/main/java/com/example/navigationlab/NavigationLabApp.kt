package com.example.navigationlab

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navigationlab.screens.AboutScreen
import com.example.navigationlab.screens.DetailScreen
import com.example.navigationlab.screens.HomeScreen
import com.example.navigationlab.screens.ProfileScreen

@Composable
fun NavigationLabApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onOpenDetail = { id -> navController.navigate(Routes.detail(id)) },
                onOpenProfile = { navController.navigate(Routes.PROFILE) },
                onOpenAbout = { navController.navigate(Routes.ABOUT) } // <-- Panggil navigate(ABOUT)
            )
        }

        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val studentId = backStackEntry.arguments?.getInt("studentId") ?: 0
            DetailScreen(
                studentId = studentId,
                onBack = { navController.popBackStack() },
                onOpenProfile = { navController.navigate(Routes.PROFILE) } // <-- Challenge
            )
        }

        composable(Routes.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() }
            )
        }

        // Poin 3: Destination About di NavHost
        composable(Routes.ABOUT) {
            AboutScreen(
                onBack = { navController.popBackStack() } // Poin 5: popBackStack()
            )
        }
    }
}