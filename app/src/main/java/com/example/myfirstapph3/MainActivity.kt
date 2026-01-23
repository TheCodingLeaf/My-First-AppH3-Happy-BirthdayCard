package com.example.myfirstapph3

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapph3.ui.theme.MyFirstAppH3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            MyFirstAppH3Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text),
                        from = stringResource(R.string.happy_birtrhday_from_txt),
                        modifier = Modifier.padding(8.dp)
                    )
                }
                FromButton()
            }
        }
    }
}

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
    val image = painterResource(R.drawable.aaaa)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null
        )
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

@Preview
@Composable
fun FromButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier
//        .fillMaxSize()
        .padding(100.dp)
    ){
        Button(
            onClick = {
                //do
            }
        ) {
            Text(text = "Click Me")
        }
    }
}