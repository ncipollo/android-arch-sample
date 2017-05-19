package levelup.scvngr.architecturesample.repository

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.injection.InjectionRule
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.model.repo.createRepoList
import levelup.scvngr.architecturesample.model.repo.createRepoListObservable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


class GitHubRepositoryTest {
    lateinit var githubApi: GithubApi
    lateinit var githubRepository: GitHubRepository
    @JvmField @Rule
    val injectionRule = InjectionRule()
    @JvmField @Rule
    val instantTask = InstantTaskExecutorRule()

    val testUser = "test"

    @Before fun setUp() {
        githubApi = injectionRule.appComponent.githubApi
        githubRepository = injectionRule.appComponent.githubRepository
        `when`(githubApi.repos(anyString())).thenReturn(createRepoListObservable())
    }

    @Test
    fun loadRepos() {
        var repos: List<Repo>? = null
        githubRepository.loadRepos(testUser).observeForever {
            repos = it
        }
        assertNotNull(repos)
        assertEquals(createRepoList(),repos)
        verify(githubApi).repos(testUser)
    }
}
