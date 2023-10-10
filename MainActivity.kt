package com.multiplataformas.practica2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.multiplataformas.practica2.ui.theme.MainActivityktTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityktTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column{
                        MessageCard(Message(author = "Él", body = "Estoy de broma" ))
                        Spacer(modifier = Modifier.height(1.dp))
                        MessageCardAnswer(Message(author = "Yo", body = "Oki doki" ))
                    }
                }
            }
        }
    }
}
data class Message (val author:String, val body:String)

@Composable
fun MessageCard(msg: Message) {
   Row (modifier = Modifier
       .padding(all = 2.dp)
       .border(width = 1.dp, color = Color.Black, shape = CircleShape)
       .background(MaterialTheme.colorScheme.secondary, CircleShape)){
        Image(
            painter = painterResource(R.drawable.julioiglesias),
            contentDescription = "Imagen de prueba",
            modifier = Modifier
                .padding(all = 8.dp)
                .size(40.dp)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)

        )
    Spacer(modifier = Modifier.width(8.dp) )


    Column {
        Text(text = msg.author,
            style = MaterialTheme.typography.titleSmall)
        Surface (modifier = Modifier
            .clip(CircleShape)
            .padding(all = 10.dp)
        ) {
        Text(text = msg.body,
            style = MaterialTheme.typography.titleMedium)
        }
    }
   }
}

@Composable
fun MessageCardAnswer(msg: Message) {

    Row (modifier = Modifier .fillMaxWidth(),
        horizontalArrangement = Arrangement.End){

       Surface(modifier = Modifier .border(width = 1.dp, color = Color.Black, shape = CircleShape)) {
        Column (modifier = Modifier
            .background(color = Color.Green, shape = CircleShape)
            .padding(all = 8.dp)) {
           // Text(text = msg.author,
                //color=Color.White
            //)
            Text(text = msg.body,
                //color=Color.White
                //Modifier
                  //  .wrapContentSize(Alignment.Center)
                    //.absoluteOffset(10.dp, 20.dp)
            )
        }
    }
    }

    //Todas los comentarios son pruebas  para futuras funciones o modificaciones que no se han quedado en la versión final
  //  Row {
        // The child with no weight will have the specified size.
    //   Box(Modifier.size(40.dp, 80.dp).background(Color.Magenta))
        // Has weight, the child will occupy half of the remaining width.
    //  Box(Modifier.height(40.dp).weight(1f).background(Color.Yellow))
        // Has weight and does not fill, the child will occupy at most half of the remaining width.
        // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
    //  Box(
        //        Modifier.size(80.dp, 40.dp)
    //            .weight(1f, fill = false)
    //             .background(Color.Green)
    //      )
    //   }
    // .padding(color= Color.Green)
    //.background(Color.Green)
}

@Preview (name ="light_mode")
@Preview (
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewMessageCard(){

    MainActivityktTheme {
        Surface{
        Column{
        MessageCard(Message(author = "Él", body = "Estoy de broma" ))
            Spacer(modifier = Modifier.height(1.dp))
        MessageCardAnswer(Message(author = "Yo", body = "Oki doki" ))
    }
    }
    }
}

