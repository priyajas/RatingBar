package com.test.example.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.test.example.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initListener()
    }

    private fun initListener() {
        var message: String? = null
        binding.ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            run {
                when (rating.toInt()) {
                    1 -> message = "Sorry to hear that"
                    2 -> message = "Thank you for rating"
                    3 -> message = "Good enough"
                    4 -> message = "Great ! Thank you"
                    5 -> message = "Awesome !!!"
                }

            }
            Toast.makeText(this, message.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}
