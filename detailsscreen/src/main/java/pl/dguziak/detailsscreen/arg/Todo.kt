package pl.dguziak.detailsscreen.arg

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import pl.dguziak.domain.model.Todo

const val TODO_ARGS = "TodoArgs"

@Parcelize
class TodoArgs(
    val userId: Long,
    val id: Long,
    val title: String,
    val completed: Boolean
) : Parcelable

fun Todo.toArgs() = TodoArgs(userId, id, title, completed)