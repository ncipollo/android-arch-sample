package levelup.scvngr.architecturesample.model.repo

import levelup.scvngr.architecturesample.model.Repo
import rx.Observable

const val repoPrefix = "repo"
const val repoListSize = 5;

fun createRepo(): Repo = Repo(repoPrefix)
fun createRepoList(): List<Repo> = List(repoListSize) { Repo("$repoPrefix $it") }
fun createRepoListObservable(): Observable<List<Repo>> = Observable.just(createRepoList())
