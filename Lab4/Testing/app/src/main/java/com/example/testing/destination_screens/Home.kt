package com.example.testing.destination_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.testing.R



@Composable
fun Course() {

        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column() {
                Card(
                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    modifier = Modifier
                        .padding(10.dp)
                         .fillMaxWidth()

                ) {
                    Text(
                        text = stringResource(id = R.string.html),
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Card(
                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = stringResource(id = R.string.java)
                        , modifier = Modifier
                            .padding(10.dp)

                    )
                }


                Card(
                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = stringResource(id = R.string.C)
                        , modifier = Modifier
                            .padding(10.dp)

                    )
                }



                Card(
                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = stringResource(id = R.string.kotlin)
                        , modifier = Modifier
                            .padding(10.dp)

                    )
                }



                Card(
                    elevation = 10.dp,
                    border = BorderStroke(1.dp, Color.Green),
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()

                ) {
                    Text(
                        text = stringResource(id = R.string.javascript)
                        , modifier = Modifier
                            .padding(10.dp)

                    )
                }






            }
        }



    }
