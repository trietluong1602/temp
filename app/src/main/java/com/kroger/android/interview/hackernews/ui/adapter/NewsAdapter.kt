package com.kroger.android.interview.hackernews.ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kroger.android.interview.hackernews.R
import com.kroger.android.interview.hackernews.Item

class NewsAdapter(private val context: Context) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    private var items: List<Item> = ArrayList()

    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.title_news)
        private val scoreTextView: TextView = itemView.findViewById(R.id.score_news)
        private val timeTextView : TextView = itemView.findViewById(R.id.time_news)

        fun bind(item: Item) {
            titleTextView.text = item.title
            scoreTextView.text = item.score.toString()
            timeTextView.text = item.time.toString()


            titleTextView.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(item.url)
                context.startActivity(intent)
            }
        }
    }
}

