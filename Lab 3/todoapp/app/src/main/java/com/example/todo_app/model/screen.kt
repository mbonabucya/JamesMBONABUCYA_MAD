package com.example.todo_app.model

import android.content.ClipData.Item
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun Screen(
   items:List<datamodel> ,
   onAddItem: (datamodel) -> Unit,
   onRemoveItem:(datamodel)->Unit
)
{
    Column {
        TodoItemInputBackground(elevate = true)
        {
            todoInput(onItemComplete = onAddItem)
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f),
               contentPadding = PaddingValues(top = 8.dp)


        )
        {
            items(items = items)
            {
                todoRow(todo = it,
                    onItemClick ={onRemoveItem(it)} , modifier = Modifier.fillMaxWidth()
                )
            }

        }

    }

}

@Composable
fun TodoItemInputBackground(
    elevate:Boolean,
    modifier: Modifier = Modifier,
    content:@Composable RowScope.() -> Unit
)  {

    val animatedElevation by animateDpAsState(if(elevate) 1.dp else 0.dp, TweenSpec(500))
    Surface(color = MaterialTheme.colors.onSurface.copy(alpha = .05f),
        shape = RectangleShape
    ) {

        Row(modifier = Modifier.animateContentSize(TweenSpec(300)),
            content = content
        )

    }
}

@Composable
fun todoRow(
    todo:datamodel,
    onItemClick:(datamodel) ->Unit,
    modifier: Modifier
)
{
    Row(modifier = Modifier
        .clickable { onItemClick(todo) }

    )
    {
        Surface() {
            val checkedState = remember { mutableStateOf(false) }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it }
            )
        }
        Surface(modifier = Modifier
            .padding(10.dp)) {
            Text(todo.task)
        }





    }
}

@Composable
fun inputField(text:String,onTextChange:(String)->Unit,modifier: Modifier){

    InputText(text,onTextChange, modifier)

}

@Composable
fun TodoEdit(
    onClick:()-> Unit,
    text:String,
    modifier: Modifier=Modifier,
    enabled:Boolean =true
)
{
    TextButton(onClick = onClick,
        shape = CircleShape,enabled=enabled,
        modifier = modifier) {
        Text(text)

    }
}




@Composable
fun todoInput(onItemComplete:(datamodel) -> Unit)
{
    val (text,setText) = remember {
        mutableStateOf("")
    }
    Column() {
        Row(
            modifier = Modifier
                .padding(horizontal = 12.dp)
                .padding(top = 8.dp)


        ) {
            inputField(text=text, onTextChange = setText,modifier = Modifier
                .padding(end = 10.dp)
                .weight(1f))

//

            TodoEdit(onClick = {onItemComplete(datamodel(text)) },
                text = stringResource(id = com.example.todo_app.R.string.add, Color.White),
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .align(Alignment.Top)
                    .background(color =MaterialTheme.colors.primary)
                    ,
                   enabled = text.isNotBlank()
                )




        }

    }
}