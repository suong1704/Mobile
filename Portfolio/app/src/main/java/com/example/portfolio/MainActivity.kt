package com.example.portfolio

import android.graphics.drawable.shapes.RectShape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.portfolio.ui.theme.PortfolioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortfolioTheme {
                val status = remember{
                    mutableStateOf(false)
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                        .background(Color.Blue),
//                    color = MaterialTheme.colors.background,
                    color = colorResource(id = R.color.purple_200),
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(12.dp),
                        shape = RoundedCornerShape(corner = CornerSize(15.dp))
                    ) {
                        Column(
                            modifier = Modifier.height(300.dp),

                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CreateImageProfile()
                            Divider()
                            CreateIfo()
                            Button(onClick = {
                                status.value =!status.value
                            }) {
                                Text(text = "Portfolio")
                            }
                            if (status.value)
                            Portfolio(data = listOf("Project 1" , "Project 2" , "Project 3" , "Project 4"))

                        }
                    }
                }
            }
        }
    }
}
@Preview
@Composable
fun CreateIfo(){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text("Nguyễn Văn Tiến" ,
            style = MaterialTheme.typography.h4 ,
            color= MaterialTheme.colors.primaryVariant)
        Text(text = "Android Programer",modifier = Modifier.padding(3.dp))
        Text(text = "@themilesCompose",
            modifier = Modifier.padding(3.dp),
            style = MaterialTheme.typography.subtitle1)
    }
}
@Preview
@Composable
fun CreateImageProfile(){
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        color = colorResource(id = R.color.purple_200),
        shape = CircleShape,
        border =  BorderStroke(0.5.dp , Color.DarkGray),
        elevation = 4.dp,
//        color = MaterialTheme.colors.background
    ) {
        Image(painter = painterResource(id = R.drawable.ic_baseline_person_outline_24),
            contentDescription = "profile image",
            modifier = Modifier.size(130.dp),
            contentScale = ContentScale.Crop)
    }
}

@Composable
fun Portfolio(data: List<String>){
    LazyColumn{
        items(data){
            item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxWidth(),


                elevation = 4.dp
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                ) {
                    CreateImageProfile()
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(text = item, fontWeight = FontWeight.Bold)
                        Text(text = "A great project" ,style = MaterialTheme.typography.body2 )

                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PortfolioTheme {
        Greeting("Android")
    }
}