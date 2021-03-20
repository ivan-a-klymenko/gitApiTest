package ru.bk.klim9.xingtest.ui.repos

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_repos.view.*
import ru.bk.klim9.xingtest.R
import ru.bk.klim9.xingtest.requests.repos.ReposItem

/**
 * @author ivan.a.klymenko@gmail.com on 3/20/21
 */
class ReposAdapter internal constructor(private val action: Action) : RecyclerView.Adapter<ReposAdapter.Holder>() {

    private var items = arrayListOf<ReposItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_repos, parent, false) as ReposItemView
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val item = items[position]
        val itemView = holder.itemView as ReposItemView
        itemView.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun setData(newItems: List<ReposItem>) {
        items = newItems as ArrayList<ReposItem>
        notifyDataSetChanged()
    }

    inner class Holder(val view: View) : RecyclerView.ViewHolder(view)

    interface Action {
        fun onReposItemLongClick()
    }

}

class ReposItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

     fun bind(item: ReposItem) {
         repoItemName.text = item.name
         repoItemLogin.text = item.ownerLogin
         repoItemDescription.text = item.description
         val backgroundColorId = if (item.isForked) R.color.light_green else R.color.white
         repoItemRoot.setBackgroundColor(ResourcesCompat.getColor(resources, backgroundColorId, null))

         Glide.with(repoItemImage.context)
             .load(item.ownerLogo)
             .into(repoItemImage)
             .waitForLayout()

     }
}