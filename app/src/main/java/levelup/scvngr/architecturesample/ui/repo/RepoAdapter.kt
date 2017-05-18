package levelup.scvngr.architecturesample.ui.repo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import levelup.scvngr.architecturesample.model.Repo

class RepoAdapter: RecyclerView.Adapter<RepoViewHolder>() {
    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) = holder.bind(Repo("foo"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(parent)
    }

    override fun getItemCount(): Int = 5
}
