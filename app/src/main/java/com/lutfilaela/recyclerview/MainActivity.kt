package com.lutfilaela.recyclerview

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.lutfilaela.recyclerview.adapter.AdapterTeamBola
import com.lutfilaela.recyclerview.databinding.ActivityMainBinding
import com.lutfilaela.recyclerview.model.Pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)


        val listPemain = ArrayList<Pemain>()
        listPemain.add(Pemain("Brahim Díaz", R.drawable.brahim, "Penyerang", "1.71 m", "Malaga", "03 Agustus 1999"))
        listPemain.add(Pemain("Federico Santiago Valverde Dipetta", R.drawable.valverde, "Gelandang", "1.82 m", "Montevideo (Uruguay)","22 Juli 1998"))
        listPemain.add(Pemain("Francisco Román  Alarcón", R.drawable.isco, "Gelandang", "1.76 m", "Benalmadena (Malaga)", "21 April 1992"))
        listPemain.add(Pemain("Rodrygo Goes", R.drawable.rodrygo, "Penyerang", "1.74 m", "Osasco (Brasil)", "09 Januari 2001"))
        listPemain.add(Pemain("Thibaut Courtois", R.drawable.courtois, "Penjaga Gawang","2.00 m","Bree (Belgia)","11 Mei 1992"))

        binding.list.adapter = AdapterTeamBola(this, listPemain, object : AdapterTeamBola.OnClikListener {
            override fun detailData(item: Pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txt_namapemain)
                    val posisi = this.findViewById<TextView>(R.id.txt_posisi)
                    val tinggi = this.findViewById<TextView>(R.id.txt_tinggibadan)
                    val tempatlahir = this.findViewById<TextView>(R.id.txt_tempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txt_tanggallahir)
                    val btn = this.findViewById<Button>(R.id.btnClose)

                    image.setImageResource(item?.foto ?: 0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()
            }
        })
    }
}