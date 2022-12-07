package com.example.testing.destination_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.testing.R

@Composable
fun Contacts() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(
                text = stringResource(id = R.string.contact),
                color = MaterialTheme.colors.secondary,
                fontSize = 34.sp,
                textAlign = TextAlign.Center
            )
            Card(
                elevation = 10.dp,
                border = BorderStroke(1.dp, Color.Green),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()


            ) {

                Column(modifier = Modifier.padding(10.dp)) {
                    Text(text = stringResource(id = R.string.phone))
                    Text(text = stringResource(id = R.string.email))
                }


            }
        }
    }
}

