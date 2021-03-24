package pl.dguziak.dtomodel

import com.squareup.moshi.JsonClass
import pl.dguziak.domain.model.Todo

@JsonClass(generateAdapter = true)
data class TodoDto(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
)

fun TodoDto.toDomain(): Todo = Todo(userId, id, title, completed)