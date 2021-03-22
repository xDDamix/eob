package pl.dguziak.domain.model

sealed class Result<TYPE> {

    class Loading<TYPE> : Result<TYPE>() {

    }

    class Success<TYPE> : Result<TYPE>() {

    }

    class Error<TYPE> : Result<TYPE>() {
    }
}
