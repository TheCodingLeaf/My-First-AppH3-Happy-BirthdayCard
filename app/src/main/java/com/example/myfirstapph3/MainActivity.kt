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
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstapph3.ui.theme.MyFirstAppH3Theme

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

                        if(showGreeting){
                            GreetingImage(
                                message = stringResource(R.string.happy_birthday_text),
                                from = stringResource(R.string.happy_birtrhday_from_txt),
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                        ShowBDtextButton(
                            onClick = { showGreeting = !showGreeting },
                            isOn = showGreeting,
                            modifier = Modifier.align(Alignment.BottomCenter)
                        )
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
fun ShowBDtextButton(
    onClick: () -> Unit,
    isOn: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.offset(y = (-50).dp)
    ) {
        Text(
            if (isOn) "Hide Greeting" else "Show Greeting",
            color = Color.White
        )
    }
}