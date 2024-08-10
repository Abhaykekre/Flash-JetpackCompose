package com.example.flash.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.flash.R

@Composable
fun StartScreen() {
     val context = LocalContext.current
     Card (modifier = Modifier.clickable {
          Toast.makeText(context, "This card was clicked", Toast.LENGTH_SHORT).show()
     }) {
          Column (
               modifier = Modifier.padding(5.dp)
          ) {
               Text(
                    text = "Hello World",
                    fontSize = 24.sp,
                    modifier = Modifier.width(150.dp)
               )
          }
          Image(
               painter = painterResource(id = R.drawable.fruits),
               contentDescription = "" ,
               modifier = Modifier.size(150.dp)
          )
     }
}
