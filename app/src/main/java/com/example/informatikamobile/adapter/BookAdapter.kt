package com.example.informatikamobile.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.informatikamobile.data.model.BookDoc
import com.example.informatikamobile.databinding.ItemBookBinding

class BookAdapter(
    private var books: List<BookDoc>,
    private val onBookClickListener: OnBookClickListener
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    interface OnBookClickListener {
        fun onBookClick(book: BookDoc)
    }

    fun setData(newData: List<BookDoc>) {
        books = newData
        notifyDataSetChanged()
    }

    class BookViewHolder(val binding: ItemBookBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.binding.tvTitle.text = book.title ?: "No Title"
        holder.binding.tvAuthor.text = book.authorName?.joinToString(", ") ?: "Unknown Author"
        holder.binding.tvYear.text = book.firstPublishYear?.toString() ?: "-"

        holder.binding.root.setOnClickListener {
            onBookClickListener.onBookClick(book)
        }
    }

    override fun getItemCount() = books.size
}
