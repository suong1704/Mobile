package com.pbl.kidstracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.pbl.kidstracker.view.LoginView
import com.pbl.kidstracker.viewmodel.LoginViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val loginViewModel = viewModel<LoginViewModel>()
            LoginView(loginViewModel)
        }
    }
}

//@Composable
//fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        topBar = { TopBar() },
//        bottomBar = { BottomNavigationBar(navController) }
//    ) {
//        Navigation(navController = navController)
//    }
//}
@Composable
fun MainScreen() {
//    val navController = rememberNavController()
//    Scaffold(
//        topBar = { TopBar() },
//        bottomBar = { BottomNavigationBar(navController) }
//    ) {
//        Navigation(navController = navController)
//    }

//    MainContent()

}
@Composable
fun LoginAndRegistration() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "login_screen", builder = {
//        composable("login_screen", content = { LoginScreen(navController = navController) })
//        composable(
//            "register_screen",
//            content = { RegistrationScreen(navController = navController) })
//    })
}
@Preview()
@Composable
fun LoginAndRegistrationPreview(){
    LoginAndRegistration()
}


