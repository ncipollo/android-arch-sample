package levelup.scvngr.architecturesample.ui.repo

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import levelup.scvngr.architecturesample.R


class RepoFragment : LifecycleFragment() {
    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repo, container, false)
    }
}
