package com.moemaair.minitime

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun Chips(minutes: List<String>) {
    var changeChipcolor by remember {
        mutableStateOf(0)
    }
    var color by remember {
        mutableStateOf(Color.Transparent)
    }

    val context = LocalContext.current.applicationContext
    LazyRow(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
        items(minutes.size){ minute ->
           Button(onClick = {
                   Toast.makeText(context, minutes[minute], Toast.LENGTH_SHORT).show()
           }, modifier = Modifier.padding(5.dp)
           )
           {
               Text(text = minutes[minute] + " minutes")
           }
        }
    }
}

