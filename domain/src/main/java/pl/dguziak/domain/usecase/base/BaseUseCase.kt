package pl.dguziak.domain.usecase.base

abstract class Args0UseCase<out RESULT> {

    abstract suspend fun execute(): RESULT
}