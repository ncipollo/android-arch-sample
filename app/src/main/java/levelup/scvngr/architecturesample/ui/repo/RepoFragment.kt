package levelup.scvngr.architecturesample.ui.repo

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_repo.*
import levelup.scvngr.architecturesample.R


class RepoFragment : LifecycleFragment() {
    val adapter = RepoAdapter()

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener {
        }
    }
}
