package com.moemaair.minitime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.moemaair.minitime.ui.theme.MiniTimeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MiniTimeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                    Home()
                    Scaffold(
                        topBar = { CenterAlignedTopAppBar(
                            title = { Text(text = "MiniTime")}
                        ) 
                            
                        }
                    ) {
                        HomeScreen(minutes = minutes)
                    }
                }
            }
        }
    }
}




@Composable
fun HomeScreen(minutes: List<String>) {
   Column(){
       Chips(minutes = minutes)
       Minute()
   }
}

@Composable
fun Minute() {
    val minute by remember {
        mutableStateOf(0)
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.size(140.dp))
           Time(minute)
           Spacer(modifier = Modifier.size(40.dp))
           Row(modifier = Modifier
               .fillMaxWidth()
               .background(MaterialTheme.colorScheme.primary), horizontalArrangement = Arrangement.SpaceAround) {
               Button(onClick = { /*TODO*/ }) {
                   Text(text = "Start")
               }
               Spacer(modifier = Modifier.size(10.dp))
               OutlinedButton(onClick = { /*TODO*/ },
                   colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.onError)) {
                   Text(text = "Stop", color = MaterialTheme.colorScheme.error)
               }
           }
    }

}

@Composable
fun Time(minute: Int) {
    Box(modifier = Modifier
        .size(200.dp)
        .clip(CircleShape)
        .background(MaterialTheme.colorScheme.primary.copy(0.7f))){
        Column(modifier = Modifier
            .fillMaxSize(0.9f)
            .clip(CircleShape)
            .background(Color.Green.copy(0.5f))
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxSize(0.9f)
                .clip(CircleShape)
                .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = minute.toString(),
                    style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}

val minutes = listOf(
    "5",
    "10",
    "15",
    "20",
    "25",
    "30",
    "35",
    "40",
    "45",
    "50",
    "55",
    "60"
)


