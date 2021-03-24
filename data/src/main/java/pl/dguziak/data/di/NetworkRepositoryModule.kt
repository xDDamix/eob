package pl.dguziak.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.qualifier
import org.koin.dsl.module
import pl.dguziak.data.PublicDataApi
import pl.dguziak.data.R
import pl.dguziak.data.repository.DataRepositoryImpl
import pl.dguziak.domain.repository.DataRepository
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkRepositoryModule = module {
    single(qualifier<BaseUrl>()) { androidContext().getString(R.string.api_base_url) }

    factory { provideOkHttpClient() }
    factory { providePublicDataApi(get()) }
    factory { provideMoshiConverterFactory() }

    single { provideRetrofit(get(qualifier<BaseUrl>()), get(), get()) }

    single<DataRepository> { DataRepositoryImpl(get()) }
}

fun provideMoshiConverterFactory(): Converter.Factory = MoshiConverterFactory.create(
    Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
)

fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().build()

fun providePublicDataApi(retrofit: Retrofit): PublicDataApi =
    retrofit.create(PublicDataApi::class.java)

fun provideRetrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient,
    converterFactory: Converter.Factory
): Retrofit = Retrofit.Builder()
    .baseUrl(baseUrl)
    .client(okHttpClient)
    .addConverterFactory(converterFactory)
    .build()

@Target(AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl