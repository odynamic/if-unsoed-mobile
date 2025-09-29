package com.example.informatikamobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.informatikamobile.databinding.ActivityHalaman2Binding

class Halaman2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityHalaman2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalaman2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initLayout() {
        // Set icon + label untuk tiap menu
        binding.layoutPhone.imgIcon.setImageResource(R.drawable.ic_phone)
        binding.layoutPhone.tvLayout.setText(R.string.telepon)

        binding.layoutEmail.imgIcon.setImageResource(R.drawable.ic_email)
        binding.layoutEmail.tvLayout.setText(R.string.email)

        binding.layoutLocation.imgIcon.setImageResource(R.drawable.ic_location)
        binding.layoutLocation.tvLayout.setText(R.string.alamat)

        binding.layoutIg.imgIcon.setImageResource(R.drawable.ic_himpunan)
        binding.layoutIg.tvLayout.setText(R.string.himpunan)
    }

    private fun initListener() {
        // Lokasi kampus → buka Google Maps via URL (string.xml)
        binding.layoutLocation.root.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.lokasi)))
            startActivity(mapIntent)
        }

        // Instagram → buka link IG HMIF
        binding.layoutIg.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ig_himpunan)))
            startActivity(intent)
        }

        // Email → buka aplikasi email
        binding.layoutEmail.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${getString(R.string.email)}")
            }
            startActivity(intent)
        }

        // Telepon → buka dialer
        binding.layoutPhone.root.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${getString(R.string.telepon)}")
            }
            startActivity(intent)
        }

        // Tombol kembali → tutup activity
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
