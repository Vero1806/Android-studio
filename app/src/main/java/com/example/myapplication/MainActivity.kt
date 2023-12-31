package com.multiplataformas.practica2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard(Message(author = "El pato donald", body = "Estoy de broma" ))
                    MessageCardAnswer(Message(author = "Yo", body = "Oki doki" ))
                }
            }
        }
    }
}
data class Message (val author:String, val body:String)


@Composable
fun MessageCard(msg: Message) {
    Row (modifier = Modifier.padding(all =8.dp)){
        Image(
                painterResource(R.drawable.julioiglesias), "Imagen de prueba",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
        )
        Spacer(modifier = Modifier.width(8.dp))

        Column {
        Text(text = msg.author)
        Text(text = msg.body)
        }
    }

}


@Composable
fun MessageCardAnswer(msg: Message) {
    Surface (modifier = Modifier
            .padding(8.dp)
    ){
        Row (modifier = Modifier .padding(all =8.dp),
                horizontalArrangement = Arrangement.End){
            Spacer(modifier = Modifier.width(100.dp))

            Column {// (Color.color)
                Text(text = msg.author)
                Text(text = msg.body)
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PreviewMessageCard(){
    MyApplicationTheme {
        Column {
            MessageCard(Message(author = "Él", body = "Estoy de broma" ))
            Spacer(modifier = Modifier.height(3.dp))
            MessageCardAnswer(Message(author = "Yo", body = "Oki doki" ))
        }
    }
}


