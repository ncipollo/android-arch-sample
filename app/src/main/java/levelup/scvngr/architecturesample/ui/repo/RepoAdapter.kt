package levelup.scvngr.architecturesample.ui.repo

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import levelup.scvngr.architecturesample.model.Repo
import kotlin.properties.Delegates

class RepoAdapter: RecyclerView.Adapter<RepoViewHolder>() {
    var repos: List<Repo> by Delegates.observable(emptyList()) { _, _, _ -> notifyDataSetChanged() }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        return holder.bind(repos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        return RepoViewHolder(parent)
    }

    override fun getItemCount(): Int = repos.size
}
