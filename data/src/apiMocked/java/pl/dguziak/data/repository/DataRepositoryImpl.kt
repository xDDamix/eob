package pl.dguziak.data.repository

import android.content.Context
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.*
import pl.dguziak.domain.model.Todo
import pl.dguziak.domain.repository.DataRepository

class DataRepositoryImpl(
    private val applicationContext: Context
) : DataRepository {

    override suspend fun getTodos(): List<Todo> =
       withContext(Dispatchers.IO) {
            val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
            val listType = Types.newParameterizedType(List::class.java, Todo::class.java)
            val adapter: JsonAdapter<List<Todo>> = moshi.adapter(listType)

            val json = applicationContext.assets.open("mocked_data.json").bufferedReader()
                .use { it.readText() }
            val list = adapter.fromJson(json)
            list ?: listOf()
        }

}