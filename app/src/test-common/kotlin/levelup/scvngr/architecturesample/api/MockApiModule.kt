package levelup.scvngr.architecturesample.api

import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
class MockApiModule {
    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi = mock(GithubApi::class.java)
}
