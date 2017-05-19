package levelup.scvngr.architecturesample.api

import levelup.scvngr.architecturesample.model.Repo
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

interface GithubApi {
    @GET("users/{user}/repos")
    fun repos(@Path("user") user: String): Observable<List<Repo>>
}
