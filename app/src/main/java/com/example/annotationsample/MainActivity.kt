package com.example.annotationsample

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.annotationsample.model.Book
import com.example.annotationsample.model.Publisher
import com.gyeongmun.generated.validate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.text_view).setOnClickListener {
            val book = Book(
                title = "title",
                price = 5000,
                authorName = "authorName",
                authorEmail = "authorEmail@email.com",
                publisher = Publisher("publisher")
            )

            val validationResult = book.validate()
            Log.v("Validation",
                StringBuilder()
                    .appendln("유효성: ${validationResult.isValid}")
                    .appendln("잘못된 필드: ${validationResult.invalidFieldNameAndTags.joinToString(", ", transform = {it.fieldName})}")
                    .appendln("메시지: ${validationResult.invalidFieldNameAndTags.joinToString(" & ", transform = { it.tag })}")
                    .toString()
            )
        }
    }
}