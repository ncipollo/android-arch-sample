package levelup.scvngr.architecturesample.ui.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import levelup.scvngr.architecturesample.model.Repo
import levelup.scvngr.architecturesample.repository.GitHubRepository
import javax.inject.Inject

class RepoViewModel @Inject constructor(private val gitHubRepository: GitHubRepository)
    : ViewModel() {
    private val userTrigger: MutableLiveData<String> = MutableLiveData()
    val repos: LiveData<List<Repo>> = Transformations.switchMap(userTrigger) {
        gitHubRepository.loadRepos(it)
    }
    var user: String = ""
        set(value) {
            field = value
            userTrigger.value = value
        }

    fun refresh() {
        userTrigger.value = user
    }
}
