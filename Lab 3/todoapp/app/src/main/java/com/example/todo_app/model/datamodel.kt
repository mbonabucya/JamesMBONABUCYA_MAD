package com.example.todo_app.model

import java.util.UUID

data class datamodel(
    val task : String,
    val id:UUID =UUID.randomUUID()
)
