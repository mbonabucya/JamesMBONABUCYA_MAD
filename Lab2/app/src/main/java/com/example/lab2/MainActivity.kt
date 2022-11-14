package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab2.ui.theme.Lab2Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primaryVariant
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Clickme(clicked: () -> Unit) {

        Button(onClick = clicked) {

            Text(
                stringResource(id = R.string.button),
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 20.dp)
                    .align(Alignment.Top)

            )
        }
    }


//function to create the textfield
@Composable
fun AddTextField(name: String, changed: (String) -> Unit) {
    TextField(
        value = name,
        label = { Text(stringResource(id = R.string.addname)) },
        onValueChange = changed,
        placeholder = { Text(stringResource(id = R.string.name)) },
        modifier = Modifier
            .width(300.dp)
            .padding(top = 40.dp, bottom = 10.dp)
            .size(60.dp)
    )
}

//output message
@Composable
fun OutputMessage(newName: String) {
    if (newName.isNotEmpty()) {
        Text(
            stringResource(R.string.Hello) + " " + newName,
            //color = Color.Blue,
            color = MaterialTheme.colors.background,
            fontSize = 34.sp,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun Greeting() {

    var name by remember { mutableStateOf("") }
    var textFieldName by remember { mutableStateOf("") }
    var image by remember {
        mutableStateOf(value = false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        AddTextField(name = textFieldName, changed = { textFieldName = it })
        Clickme {
            name = textFieldName
            image = !image

        }
       Image(
            painter = painterResource(
                if (image) {
                   R.drawable.img_1
                } else {
                    R.drawable.img
                }
            ),
           contentDescription = stringResource(id = R.string.Food),
           modifier = Modifier
                .padding(top = 20.dp, bottom = 10.dp, start = 30.dp)
                .size(240.dp).clip(CircleShape)
               //.align(Alignment.Start)
              .align(Alignment.CenterHorizontally)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(300.dp)
                .height(60.dp)
                .background(Color.Blue)
        )
        {
            OutputMessage(newName = name)
        }

    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lab2Theme {
        //Greeting(stringResource(id =R.string.Name ))
        Greeting()
    }
}