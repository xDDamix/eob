package pl.dguziak.domain.repository

import pl.dguziak.domain.model.Todo

interface DataRepository {

    suspend fun getTodos(): List<Todo>
}