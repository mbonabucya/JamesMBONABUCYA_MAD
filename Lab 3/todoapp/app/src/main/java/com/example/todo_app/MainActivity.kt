package com.example.todo_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo_app.model.Screen
import com.example.todo_app.model.datamodel
import com.example.todo_app.model.viewModel
import com.example.todo_app.ui.theme.TodoappTheme

class MainActivity : ComponentActivity() {
    private val todoviewmodel by viewModels<viewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoappTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //call the function here

                    todoScreenActivity(todoviewmodel)
                }
            }
        }
    }
}

@Composable
private fun todoScreenActivity(todoviewmodel:viewModel)
{
    val items:List<datamodel> by todoviewmodel.todoItem.observeAsState(listOf())
    Screen(items = items, onAddItem ={todoviewmodel.additem(it)} , onRemoveItem ={todoviewmodel.deleteItem(it)} )
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoappTheme(darkTheme = false) {

    }
}

@Preview(showBackground = true)
@Composable
fun DarkDefaultPreview() {
    TodoappTheme(darkTheme = true) {

    }
}