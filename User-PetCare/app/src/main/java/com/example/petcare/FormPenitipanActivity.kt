package com.example.petcare

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_form_penitipan.*
import org.json.JSONArray
import java.util.*

class FormPenitipanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_penitipan)

        pilihtanggaltitipan()
        pilihtanggalkembali()
        tambahdatatitipan()
    }
    fun pilihtanggaltitipan(){
        val c_titipan = Calendar.getInstance()
        val year_titipan = c_titipan.get(Calendar.YEAR)
        val month_titipan = c_titipan.get(Calendar.MONTH)
        val day_titipan = c_titipan.get(Calendar.DAY_OF_MONTH)

        datepicktitipan.setOnClickListener(){
            val dpd_titipan = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                // Display Selected date in TextView
                tanggal_penitipan.setText("" + mYear + "-" + mMonth+ "-" + mDay)
            }, year_titipan, month_titipan, day_titipan )
            dpd_titipan.show()
        }
    }
    fun pilihtanggalkembali(){
        val c_kembali = Calendar.getInstance()
        val year_kembali= c_kembali.get(Calendar.YEAR)
        val month_kembali = c_kembali.get(Calendar.MONTH)
        val day_kembali = c_kembali.get(Calendar.DAY_OF_MONTH)

        datepickkembali.setOnClickListener(){
            val dpd_kembali = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                // Display Selected date in TextView
                tanggal_kembali.setText("" + mYear+ "-" + mMonth+ "-" + mDay)
            }, year_kembali, month_kembali, day_kembali)
            dpd_kembali.show()
        }
    }

    fun tambahdatatitipan(){
        addtitipan.setOnClickListener(){
            var v_nama_pemilik = nama_pemilik.text.toString()
            var v_alamat_pemilik = alamat_pemilik.text.toString()
            var v_no_hp = no_hp.text.toString()
            var v_nama_hewan = nama_hewan.text.toString()
            var v_jenis_kelamin= jenis_kelamin.text.toString()
            var v_tanggal_penitipan= tanggal_penitipan.text.toString()
            var v_tanggal_kembali = tanggal_kembali.text.toString()

            postkeserver(v_nama_pemilik, v_alamat_pemilik, v_no_hp, v_nama_hewan,v_jenis_kelamin, v_tanggal_penitipan,v_tanggal_kembali )

            val tologin = Intent(this, HomeActivity::class.java)
            startActivity(tologin)
        }
    }
    fun postkeserver(data:String, data2:String, data3:String, data4 :String, data5:String, data6:String, data7:String){
        AndroidNetworking.post("http://192.168.1.248/Semester_4/Mobile_Programming_Terapan/UAS/API/pet_care/add_hewan.php")
            .addBodyParameter("nama_pemilik", data)
            .addBodyParameter("alamat_pamilik", data2)
            .addBodyParameter("no_hp", data3)
            .addBodyParameter("nama_hewan", data4)
            .addBodyParameter("jenis_kelamin", data5)
            .addBodyParameter("tanggal_penitipan", data6)
            .addBodyParameter("tanggal_kembali", data7)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                }
                override fun onError(anError: ANError?) {
                }
            })
    }
}
