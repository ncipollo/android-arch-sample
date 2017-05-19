package levelup.scvngr.architecturesample.injection

import dagger.Component
import levelup.scvngr.architecturesample.api.GithubApi
import levelup.scvngr.architecturesample.api.MockApiModule
import levelup.scvngr.architecturesample.repository.GitHubRepository
import levelup.scvngr.architecturesample.ui.repo.RepoViewModel
import levelup.scvngr.architecturesample.viewmodel.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(MockApiModule::class, MockAppModule::class, ViewModelModule::class))
interface TestAppComponent {
    val fragmentComponent: FragmentSubComponent
    val githubApi: GithubApi
    val githubRepository: GitHubRepository
    val repoViewModel: RepoViewModel
}
