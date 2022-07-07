package com.example.jettip

import android.net.wifi.aware.IdentityChangedListener
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jettip.ui.theme.primaryLightColor
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun TopHeader(total: Float){
        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 10.dp,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(20.dp, 20.dp, 20.dp, 20.dp)),
            color = colorResource(id = R.color.purple_200),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Total Per Person",
                    fontSize = 30.sp
                )
                Text(text = "$"+"${total}",
                    fontSize = 35.sp)
            }
        }

}
@Composable
fun EnterBill(number: MutableState<String>){
         OutlinedTextField(
             value = number.value,
             onValueChange = { number.value = it},
             label = { Text("Enter Bill") },
             keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
             modifier = Modifier.fillMaxWidth().padding(10.dp),
             leadingIcon = {
                 Icon(painter = painterResource(id = R.drawable.ic_baseline_attach_money_24), contentDescription = "Icon")
             },
         )
}
@Composable
fun Split(number : Int , onClickDown: (Int) -> Unit , onClickUp: (Int) -> Unit){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Split",
            modifier = Modifier.width(150.dp)
        )
        Button(
            onClick = { onClickDown(number-1)},
            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White,contentColor = Color.Black),

        ){
            Text(text = "-",color = Color.Black)
        }
        Text(
            modifier = Modifier.padding(20.dp),
            text = "$number"
        )
        Button(

            shape = CircleShape,
            modifier = Modifier.size(40.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White,contentColor = Color.Black),
            onClick = { onClickUp(number+1) },
        ){
            Text(text = "+",color = Color.Black)
        }
    }
}
@Composable
fun Tip(tip: Float){
    Row {
        Text(
            text = "Tip",
            modifier = Modifier.width(150.dp)
        )
        Text(
            text = "$"+"${tip}",
        )

    }
}
@Composable
fun Slider(sliderPosition: MutableState<Float> )
{
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "${sliderPosition.value.toInt()}"+" %",
        )
        Slider(
            value = sliderPosition.value,
            onValueChange = { sliderPosition.value = it },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                sliderPosition.value
            },
            steps = 9,
            colors = SliderDefaults.colors(
                thumbColor = colorResource(id = R.color.purple_500),
                activeTrackColor = colorResource(id = R.color.purple_500)
            )
        )
    }
}
@Composable
fun MainContent(){
    var sliderPosition = remember { mutableStateOf(0f) }
    var bill  = remember { mutableStateOf("") }
    var split by remember { mutableStateOf(1) }
    var tip by remember { mutableStateOf(0f)}
    var total by remember { mutableStateOf(0f) }
    if ( split < 0 ) {split = 0}
    if (bill.value != ""){
        tip = bill.value.toFloat() * split.toFloat() * sliderPosition.value.toInt().toFloat()/100
        total = bill.value.toFloat() * split.toFloat() + tip
    }
    Surface (modifier = Modifier
        .padding(10.dp)
        .fillMaxSize()){
        Column() {
            TopHeader(total = total)
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 10.dp,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .wrapContentHeight()
                ) {
                    EnterBill(bill)

                        if (bill.value != "") {
                            Spacer(modifier = Modifier.width(20.dp))
                            Split(number = split, { split -= 1 }, { split += 1 })
                            Spacer(modifier = Modifier.height(20.dp))
                            Tip(tip)
                            Spacer(modifier = Modifier.height(20.dp))
                            Slider(sliderPosition)
                        }

                }
            }
        }
    }
}
@Preview
@Composable
fun MainContentPreview(){
    MainContent()
}



