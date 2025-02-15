package com.example.myapplication.nav

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.myapplication.ui.component.BottomNav
import com.example.myapplication.ui.view.CombinationView
import com.example.myapplication.ui.view.HomeView
import com.example.myapplication.ui.view.InformationView
import com.example.myapplication.ui.view.OutfitView
import com.example.myapplication.ui.view.ResultView
import com.example.myapplication.ui.view.SearchView
import com.example.myapplication.ui.view.WearingView
import com.example.myapplication.ui.view.WishlistView

object MainNavGroup {
    const val HOME = "home"
    const val SEARCH = "search/{keyword}"
    const val OUTFIT = "outfit"
    const val INFORMATION = "information"
    const val WISHLIST = "wishlist"
    const val COMBINATION = "combination"
    const val RESULT = "result"
    const val WEARING = "wearing"
}

@Composable
fun MainNavGraph(navController: NavHostController){
    val startDestination = MainNavGroup.HOME
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route
    Box (
        modifier = Modifier.fillMaxSize(),
        content = {
            NavHost(
                navController = navController,
                startDestination = startDestination
            ){
                composable(route = MainNavGroup.HOME) {
                    HomeView(navController)
                }
                composable(
                    route = MainNavGroup.SEARCH,
                    arguments = listOf(navArgument("keyword") { type = NavType.StringType })
                ) { backStackEntry ->
                    val keyword = backStackEntry.arguments?.getString("keyword")
                    SearchView(navController, keyword)
                }
                composable(route = MainNavGroup.OUTFIT) {
                    OutfitView(navController)
                }
                composable(route = MainNavGroup.INFORMATION) {
                    InformationView()
                }
                composable(route = MainNavGroup.WISHLIST) {
                    WishlistView()
                }
                composable(route = MainNavGroup.COMBINATION) {
                    CombinationView()
                }
                composable(route = MainNavGroup.RESULT) {
                    ResultView()
                }
                composable(route = MainNavGroup.WEARING) {
                    WearingView()
                }
            }
            if (currentRoute != MainNavGroup.SEARCH) {
                BottomNav(
                    navController,
                    modifier = Modifier.align(Alignment.BottomCenter)
                )
            }
        },

    )
}
