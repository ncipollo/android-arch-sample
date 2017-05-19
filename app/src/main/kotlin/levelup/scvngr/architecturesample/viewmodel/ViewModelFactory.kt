package levelup.scvngr.architecturesample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import levelup.scvngr.architecturesample.ui.repo.RepoViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(val viewModelComponent: ViewModelSubComponent)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>?): T {
        @Suppress("UNCHECKED_CAST")
        return when(modelClass) {
            RepoViewModel::class.java -> viewModelComponent.repoViewModel as T
            else -> throw IllegalArgumentException("Invalid view model class: $modelClass")
        }
    }
}
