package levelup.scvngr.architecturesample.injection

import dagger.Subcomponent
import levelup.scvngr.architecturesample.ui.repo.RepoFragment

@Subcomponent
interface FragmentSubComponent {
    fun inject(repoFragment: RepoFragment)
}
