package com.example.myfirstapph3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapph3.ui.theme.MyFirstAppH3Theme
import kotlinx.coroutines.delay

/**
 * Main Activity of the Happy Birthday App
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MyFirstAppH3Theme {
                var showGreeting by remember { mutableStateOf(false) }
                var isFromNameInserted by remember { mutableStateOf(false) }
                var isBDNameInserted by remember { mutableStateOf(false) }
                var showFromConfirmButton by remember { mutableStateOf(true) }
                var showBDConfirmButton by remember { mutableStateOf(true) }
                var fromName by remember { mutableStateOf("") }
                var toName by remember { mutableStateOf("") }

                //Game Variables
                var dollarCount by remember { mutableIntStateOf(1000) }
                var dollarCountPerSecond by remember { mutableIntStateOf(0) }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(modifier = Modifier.fillMaxSize()){
                        Image(
                            painter = painterResource(R.drawable.aaaa),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        ShowDollarAmount(
                            dollarCount = dollarCount,
                            dollarCountPerSecond = dollarCountPerSecond,
                            modifier = Modifier.align(Alignment.TopCenter)
                        )
                        Gain1DollarButton(
                            onClick = { dollarCount++ },
                            modifier = Modifier.align(Alignment.TopCenter)
                        )
                        //Dollars Per Second Shop
                        if(dollarCount >= 10){
                            AddDollarsASecButton(
                                onClick = {
                                    dollarCount -= 10
                                    dollarCountPerSecond++
                                },
                                value = "+1$/s Cost: 10$",
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(top = 150.dp)
                            )
                        }
                        if(dollarCount >= 100){
                            AddDollarsASecButton(
                                onClick = {
                                    dollarCount -= 100
                                    dollarCountPerSecond += 10
                                },
                                value = "+10$/s Cost: 100$",
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(top = 195.dp)
                            )
                        }
                        if(dollarCount >= 1000){
                            AddDollarsASecButton(
                                onClick = {
                                    dollarCount -= 1000
                                    dollarCountPerSecond += 100
                                },
                                value = "+100$/s  Cost: 1000$",
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(top = 240.dp)
                            )
                        }
                        //Dollars Per Second Calculations
                        LaunchedEffect(Unit) {
                            while(true) {
                                if(dollarCountPerSecond > 0) {
                                    dollarCount += dollarCountPerSecond
                                }
                                delay(1000L) // 1 second
                            }
                        }



//                        if(showGreeting){
//                            GreetingImage(
//                                message = "Happy Birthday - $toName",
//                                from = "From - $fromName",
//                                modifier = Modifier.padding(8.dp)
//                            )
//                        }
//                        if(!showFromConfirmButton){
//                            ShowBirthDayTextButton(
//                                onClick = { showGreeting = !showGreeting },
//                                isOn = showGreeting,
//                                modifier = Modifier.align(Alignment.BottomCenter)
//                            )
//                        }
//                        if(showFromConfirmButton){
//                            AppButton(
//                                onClick = { isFromNameInserted = true} ,
//                                value = "Confirm",
//                                modifier = Modifier.align(Alignment.BottomCenter)
//                            )
//                            AppTextField(
//                                value = fromName,
//                                onValueChange = {value -> fromName = value },
//                                label = "Enter Recipient's Name",
//                                modifier = Modifier.align(Alignment.Center)
//                            )
//                        }
//                        if(showBDConfirmButton){
//                            AppButton(
//                                onClick = { isBDNameInserted = true} ,
//                                value = "Confirm",
//                                modifier = Modifier.align(Alignment.BottomCenter)
//                            )
//                            AppTextField(
//                                value = toName,
//                                onValueChange = {value -> toName = value },
//                                label = "Enter Your Name",
//                                modifier = Modifier.align(Alignment.Center)
//                            )
//                        }
//                        //This seems like it could be done better later on
//                        if(isFromNameInserted){
//                            showFromConfirmButton = false
//                        }
//                        if(isBDNameInserted){
//                            showBDConfirmButton = false
//                        }
                    }
                }
            }
        }
    }
}

/**
 * Displays The Greeting
 * @param message, message
 * @param from, from
 */
@Composable
fun Greeting(message: String, from: String, color: Color, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(
            8.dp
        )) {
        Text(
            text = message,
            color = Color.Cyan,
            fontSize = 90.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            color = Color.White,
            fontSize = 36.sp,
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.End),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    Box(modifier) {
        Greeting(
            message = message,
            color = Color.Cyan,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}
@Preview (showBackground = true)
@Composable
fun BirthdayCardPreview(){
    MyFirstAppH3Theme() {
        Box {
            GreetingImage(
                message = stringResource(R.string.happy_birthday_text),
                from = stringResource(R.string.happy_birtrhday_from_txt)
            )
        }
    }
}
@Composable
fun ShowBirthDayTextButton(
    onClick: () -> Unit,
    isOn: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.offset(y = (-50).dp)

    ) {
        Text(
            if (isOn) "Close" else "Open",
            color = Color.White
        )
        Image(
            painter = painterResource(R.drawable.gift),
            modifier = Modifier.offset(x = 10.dp),
            contentDescription = null,
        )
    }
}
//Reusable Button
@Composable
fun AppButton(
    onClick: () -> Unit,
    value: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(bottom = 370.dp)
    ){
        Text(
            value
        )
    }
}
//Reusable TextField
@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier
    )
}
//Clicker Game
@Composable
fun ShowDollarAmount(
    dollarCount: Int,
    dollarCountPerSecond: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = buildAnnotatedString {
            append("You have ")
            withStyle(SpanStyle(color = Color.Green)) {
                append("$dollarCount")
            }
            append(" dollars")
            append(" ")
            withStyle(SpanStyle(color = Color.Green)) {
                append("+$dollarCountPerSecond")
            }
        },
        color = Color.White,
        modifier = modifier.padding(top = 70.dp)
    )
}
@Composable
fun Gain1DollarButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(top = 100.dp)
    ){
        Text(
            "+1$"
        )
    }
}
@Composable
fun AddDollarsASecButton(
    onClick: () -> Unit,
    value: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ){
        Text(
            text = value
        )
    }
}