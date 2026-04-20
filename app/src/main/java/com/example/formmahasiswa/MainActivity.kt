package com.example.formmahasiswa

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNama = findViewById<EditText>(R.id.etNama)
        val groupGender = findViewById<RadioGroup>(R.id.rgGender)

        val hobiMembaca = findViewById<CheckBox>(R.id.cbMembaca)
        val hobiCoding = findViewById<CheckBox>(R.id.cbCoding)
        val hobiOlahraga = findViewById<CheckBox>(R.id.cbOlahraga)
        val hobiMenulis = findViewById<CheckBox>(R.id.cbMenulis)

        val tombolTampil = findViewById<Button>(R.id.btnTampilkan)
        val hasilView = findViewById<TextView>(R.id.tvHasil)

        tombolTampil.setOnClickListener {

            val namaInput = inputNama.text.toString().trim()

            if (namaInput.isEmpty()) {
                inputNama.error = "Nama tidak boleh kosong"
                Toast.makeText(this, "Nama tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idGenderTerpilih = groupGender.checkedRadioButtonId
            if (idGenderTerpilih == -1) {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val radioTerpilih = findViewById<RadioButton>(idGenderTerpilih)
            val jenisKelamin = radioTerpilih.text.toString()

            val daftarHobi = mutableListOf<String>()

            if (hobiMembaca.isChecked) daftarHobi.add("Membaca")
            if (hobiCoding.isChecked) daftarHobi.add("Coding")
            if (hobiOlahraga.isChecked) daftarHobi.add("Olahraga")
            if (hobiMenulis.isChecked) daftarHobi.add("Menulis")

            val hasilHobi = if (daftarHobi.isEmpty()) {
                "Hobi tidak ada"
            } else {
                daftarHobi.joinToString(", ")
            }

            // Output hasil
            val output = """
                Nama    : $namaInput
                Kelamin : $jenisKelamin
                Hobi    : $hasilHobi
            """.trimIndent()

            hasilView.text = output
        }
    }
}