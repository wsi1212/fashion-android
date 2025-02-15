package com.example.myapplication.nav

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    const val SEARCH = "search"
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
    Log.d("adfjji","${navController.currentBackStackEntry?.destination?.route}")
    Scaffold (
        content = {
            NavHost(
                navController = navController,
                modifier = Modifier.padding(it),
                startDestination = startDestination
            ){
                composable(route = MainNavGroup.HOME) {
                    HomeView()
                }
                composable(route = MainNavGroup.SEARCH) {
                    SearchView()
                }
                composable(route = MainNavGroup.OUTFIT) {
                    OutfitView()
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
        },
        bottomBar = {
            BottomNav(navController)
        }
    )
}
