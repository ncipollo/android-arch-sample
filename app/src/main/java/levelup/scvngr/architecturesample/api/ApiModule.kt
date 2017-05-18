package levelup.scvngr.architecturesample.api

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import javax.inject.Singleton

@Module
class ApiModule {
    val retrofit: Retrofit

    init {
        val rxAdapter = RxJavaCallAdapterFactory
                .createWithScheduler(Schedulers.io())
        retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build()
    }

    @Provides
    @Singleton
    fun provideGithubApi() : GithubApi = retrofit.create(GithubApi::class.java)

}
