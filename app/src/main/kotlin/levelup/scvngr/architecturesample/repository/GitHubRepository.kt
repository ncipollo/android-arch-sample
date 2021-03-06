package levelup.scvngr.architecturesample.repository

import android.arch.lifecycle.LiveData
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.rx.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GitHubRepository @Inject constructor(private val api: GithubApi,
        private val schedulers: Schedulers) {
    fun loadRepos(user: String): LiveData<List<Repo>> = RepoListLiveData(api, schedulers, user)
}

private class RepoListLiveData(api: GithubApi,
        schedulers: Schedulers,
        user: String) : LiveData<List<Repo>>() {
    init {
        api.repos(user)
                .onErrorReturn { emptyList() }
                .observeOn(schedulers.mainThread)
                .subscribe {
                    value = it
                }
    }
}
