package com.example.sharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var btnSave : Button
    private lateinit var btnShow : Button
    private lateinit var number : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // استدعاء الدوال
        init() ; save() ; show()

    }
    // دالة عرض البيانات التى تم تخزينها عند الضغط على الزر
    private fun show(){
        btnShow.setOnClickListener {
            val sharedPreference = getSharedPreferences("savePhone" ,Context.MODE_PRIVATE)
    // الحصول على النص من داخل الملف عن طريق المفتاح
            val phone = sharedPreference.getString("Phone","00")
            number.text = phone
        }
    }
    // دالة تخزين البيانات وحفظها فى الهاتف عند الضغط على الزر
    private fun save(){
        btnSave.setOnClickListener {
    //                  مدى السماح بالوصول للملف من التطبيقات الاخرى  //   مفتاح              نوعه            متغير
            val sharedPreference = getSharedPreferences("savePhone" ,Context.MODE_PRIVATE)
    // هذا المتغير من اجل تنفيذ دالة edit() وذلك للاستفادة من حفظ البيانات ووضعها داخل الملف ومن ثم تنفيذ ذلك كما سياتى
            val edit = sharedPreference.edit()
    // هذا لوضع النص داخل الملف عن طريق المفتاح والقيمة
            edit.putString("Phone",editText.text.toString())
     // هذا لتفعيل ما كتبناه
             edit.apply()
      // دى رسالة قصيرة للتاكد
            Toast.makeText(this,"تم حفظ رقم الجوال ", Toast.LENGTH_LONG).show()
        }
    }
    // تعريف العناصر
    private fun init (){
        editText = findViewById(R.id.edit_text)
        btnSave  =  findViewById(R.id.save)
        btnShow = findViewById(R.id.show)
        number = findViewById(R.id.number)
    }
}