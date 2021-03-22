package pl.dguziak.data

import pl.dguziak.dtomodel.TodoDto
import retrofit2.http.GET

interface PublicDataApi {

    @GET("/todos")
    suspend fun getTodos(): List<TodoDto>
}