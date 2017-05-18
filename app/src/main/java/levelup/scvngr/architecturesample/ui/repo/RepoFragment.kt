package levelup.scvngr.architecturesample.ui.repo

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_repo.*
import levelup.scvngr.architecturesample.R
import levelup.scvngr.architecturesample.injection.Injector
import levelup.scvngr.architecturesample.viewmodel.ViewModelFactory
import javax.inject.Inject


class RepoFragment : LifecycleFragment() {
    val adapter = RepoAdapter()
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Injector.fragmentComponent.inject(this)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepoViewModel::class.java)
        viewModel.repos.observe(this, Observer {
            adapter.repos = it ?: emptyList()
        })
    }

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        refreshLayout.setOnRefreshListener { }
    }
}
