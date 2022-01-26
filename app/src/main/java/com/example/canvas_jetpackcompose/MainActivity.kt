package com.example.canvas_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.canvas_jetpackcompose.component.CanvasCircle
import com.example.canvas_jetpackcompose.ui.theme.CanvasjetPackComposeTheme
import com.example.canvas_jetpackcompose.viewmodel.CanvasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CanvasjetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    ComposeCanvas()
                }
            }
        }
    }
}

@Composable
fun ComposeCanvas() {
    val scaffoldState = rememberScaffoldState()
    val viewModel: CanvasViewModel = viewModel()
    val sec = viewModel.sec.observeAsState()

    viewModel.countDown(30000L)

    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState) {

        Column(modifier = Modifier.fillMaxSize()) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Circle Canvas", fontWeight = FontWeight.Bold, fontSize = 20.sp,
                    color = Color.White
                )
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CanvasCircle(percentage = sec.value!!.toFloat())
            }
        }
    }
}