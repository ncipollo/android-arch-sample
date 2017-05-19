package levelup.scvngr.architecturesample.viewmodel

import dagger.Subcomponent
import levelup.scvngr.architecturesample.ui.repo.RepoViewModel

@Subcomponent
interface ViewModelSubComponent {
    @Subcomponent.Builder
    interface Builder {
        fun build(): ViewModelSubComponent
    }
    val repoViewModel: RepoViewModel
}
