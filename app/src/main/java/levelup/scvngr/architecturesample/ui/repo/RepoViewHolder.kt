package levelup.scvngr.architecturesample.ui.repo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repository.view.*
import levelup.scvngr.architecturesample.R
import levelup.scvngr.architecturesample.model.Repo

class RepoViewHolder(parent: ViewGroup)
    : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
                .inflate(R.layout.item_repository, parent, false)) {

    fun bind(repo: Repo) {
        itemView.name.text = repo.name
    }
}
