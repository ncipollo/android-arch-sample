package levelup.scvngr.architecturesample.api

import dagger.Module
import dagger.Provides
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.model.repo.createRepoListObservable
import rx.Observable
import javax.inject.Singleton

@Module
class MockApiModule {
    @Provides
    @Singleton
    fun proviprovideGithubApi() = object:GithubApi {
        override fun repos(user: String): Observable<List<Repo>> = createRepoListObservable()
    }
}
