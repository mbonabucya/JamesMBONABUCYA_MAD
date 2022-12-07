package com.example.testing
import com.example.testing.destination_screens.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testing.ui.theme.TestingTheme
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestingTheme {

                Screen()
                
                }
            }
        }
    }


@Composable
fun Screen() {
    val navController = rememberNavController()

    @Composable
    fun NavigationHost(navController: NavHostController) {
        NavHost(navController = navController, startDestination = NavigationRoutes.Course.route)
        {
            composable(NavigationRoutes.Course.route)
            {
                Course()
            }
            composable(NavigationRoutes.Contacts.route)
            {
                Contacts()
            }
            composable(NavigationRoutes.Profile.route)
            {
                Profile()
            }
        }

    }


    @Composable
    fun BottomNavigationBar(navController: NavHostController) {

        BottomNavigation {

            val backStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = backStackEntry?.destination?.route
            navbaritems.BarItems.forEach { navItem ->
                BottomNavigationItem(
                    selected = currentRoute == navItem.route,
                    onClick = {
                        /*TODO*/
                        navController.navigate(navItem.route)
                        {
                            popUpTo(navController.graph.findStartDestination().id)
                            {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = navItem.image,
                            contentDescription = navItem.title
                        )
                    },
                    label = {
                        Text(text = navItem.title)
                    },
                )


            }
        }
    }

    Scaffold(
        topBar = { TopAppBar(title = {Text("Learn Coding")})},
        content = { NavigationHost(navController = navController) },
        bottomBar = { BottomNavigationBar(navController = navController)}
    )
}














