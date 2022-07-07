package com.pbl.safemykidsapp

import android.os.Bundle
import android.os.PersistableBundle
import android.service.voice.VoiceInteractionSession
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.pbl.safemykidsapp.databinding.ActivityMainBinding
import com.pbl.safemykidsapp.ui.theme.SafeMyKidsAppTheme


class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private  lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeMyKidsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ButtomAppBar()
                }
            }
        }
    }
}

@Composable
fun ButtomAppBar() {

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}