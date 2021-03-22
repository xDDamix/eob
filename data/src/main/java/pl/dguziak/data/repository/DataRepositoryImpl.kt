package pl.dguziak.data.repository

import pl.dguziak.data.PublicDataApi
import pl.dguziak.domain.model.Todo
import pl.dguziak.domain.repository.DataRepository
import pl.dguziak.dtomodel.toDomain

class DataRepositoryImpl(
    private val publicDataApi: PublicDataApi
) : DataRepository {

    override suspend fun getTodos(): List<Todo> {
        return publicDataApi.getTodos().map { it.toDomain() }.toList()
    }
}