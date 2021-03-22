package pl.dguziak.domain.usecase

import pl.dguziak.domain.model.Todo
import pl.dguziak.domain.repository.DataRepository
import pl.dguziak.domain.usecase.base.Args0UseCase

class GetTodosUseCase (
    private val dataRepository: DataRepository
) : Args0UseCase<List<Todo>>() {

    override suspend fun execute(): List<Todo> {
        return dataRepository.getTodos()
    }
}