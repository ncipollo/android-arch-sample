package levelup.scvngr.architecturesample.repository

import android.arch.lifecycle.LiveData
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.rx.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class GitHubRepository @Inject constructor(val api: GithubApi, val schedulers: Schedulers) {
    fun loadRepos(user: String): LiveData<List<Repo>> = RepoListLiveData(api, schedulers, user)
}

private class RepoListLiveData(api: GithubApi,
        schedulers: Schedulers,
        user: String) : LiveData<List<Repo>>() {
    init {
        api.repos(user)
                .onErrorReturn { emptyList() }
                .delay(3000, TimeUnit.MILLISECONDS)
                .observeOn(schedulers.mainThread)
                .subscribe {
                    value = it
                }
    }
}
