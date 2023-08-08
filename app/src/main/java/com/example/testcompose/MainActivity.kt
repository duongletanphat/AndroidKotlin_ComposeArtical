package com.example.testcompose

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticalApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticalApp(){
    ArticalCard(
        title = stringResource(R.string.title),
        openText = stringResource(R.string.open_text),
        bodyText = stringResource(R.string.body_text),
        imagePainter = painterResource(R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticalCard(
    title: String,
    openText: String,
    bodyText: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier
){
    Column {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = title,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = openText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = bodyText,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestComposeTheme {
            ComposeArticalApp()
    }
}