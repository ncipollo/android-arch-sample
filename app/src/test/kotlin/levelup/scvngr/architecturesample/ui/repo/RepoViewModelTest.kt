package levelup.scvngr.architecturesample.ui.repo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.injection.InjectionRule
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.model.repo.createRepoList
import levelup.scvngr.architecturesample.model.repo.createRepoListObservable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class RepoViewModelTest {
    lateinit var githubApi: GithubApi
    lateinit var viewModel: RepoViewModel

    @JvmField @Rule
    val injectionRule = InjectionRule()
    @JvmField @Rule
    val instantTask = InstantTaskExecutorRule()

    @Before fun setUp() {
        githubApi = injectionRule.appComponent.githubApi
        viewModel = injectionRule.appComponent.repoViewModel
        `when`(githubApi.repos(ArgumentMatchers.anyString())).thenReturn(
                createRepoListObservable())
    }

    @Test
    fun loadRepos() {
        val testUser = "test"
        var repos: List<Repo>? = null
        viewModel.user = testUser
        viewModel.repos.observeForever {
            repos = it
        }
        Assert.assertEquals(createRepoList(), repos)
        verify(githubApi, times(1)).repos(testUser)
    }

    @Test
    fun refresh() {
        val testUser = "test"
        viewModel.user = testUser
        viewModel.repos.observeForever { }
        verify(githubApi, times(1)).repos(testUser)
        viewModel.refresh()
        verify(githubApi, times(2)).repos(testUser)
    }

    @Test
    fun user() {
        val user1 = "user1"
        val user2 = "user2"
        viewModel.user = user1
        viewModel.repos.observeForever { }
        verify(githubApi, times(1)).repos(user1)
        viewModel.user = user2
        verify(githubApi, times(1)).repos(user2)
    }
}
