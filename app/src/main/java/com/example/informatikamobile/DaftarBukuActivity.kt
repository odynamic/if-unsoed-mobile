package com.example.informatikamobile

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.informatikamobile.adapter.BookAdapter
import com.example.informatikamobile.databinding.ActivityDaftarBukuBinding
import com.example.informatikamobile.viewmodel.MainViewModel

class DaftarBukuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBukuBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: BookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBukuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = BookAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.books.observe(this) { books ->
            adapter.setData(books)
            Toast.makeText(this, "Jumlah data: ${books.size}", Toast.LENGTH_SHORT).show()
        }

        viewModel.searchBooks("kotlin programming")
    }
}
