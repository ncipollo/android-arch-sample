package levelup.scvngr.architecturesample.ui.repo

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import levelup.scvngr.architecturesample.model.Repo
import rx.Observable
import java.util.concurrent.TimeUnit

class RepoViewModel: ViewModel() {
    val repos: LiveData<List<Repo>> = RepoLiveData()
}

private class RepoLiveData: LiveData<List<Repo>>() {
    init {
        Observable.timer(3000,TimeUnit.MILLISECONDS)
                .flatMap { Observable.just(1,2,3,4,5) }
                .map { Repo("Repo $it") }
                .toList()
                .subscribe { postValue(it) }
    }
}
