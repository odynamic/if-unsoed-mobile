package com.example.informatikamobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.informatikamobile.data.model.BookDoc
import com.example.informatikamobile.databinding.ItemBookBinding

class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private val data = mutableListOf<BookDoc>()

    fun setData(newData: List<BookDoc>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = data[position]
        holder.binding.tvTitle.text = book.title ?: "No Title"
        holder.binding.tvAuthor.text = book.authorName?.joinToString(", ") ?: "Unknown"
        holder.binding.tvYear.text = book.firstPublishYear?.toString() ?: "-"
    }

    override fun getItemCount() = data.size
}
