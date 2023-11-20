package com.example.homework10_profiledesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework10_profiledesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUp()
    }

    private fun setUp() {
        loadUser()
        setRecycler()
    }

    private fun loadUser() {
        val user = User("Andrew Ainsley", "+1 111 467 378 399", R.drawable.profile_photo)

        binding.TVName.text = user.name
        binding.TVPhoneNumber.text = user.phoneNumber
        binding.imgProfile.setImageResource(user.profilePhoto)
    }

    private fun setRecycler() {
        val buttons = listOf<Button>(
            Button(1, R.drawable.ic_edit_profile.toDrawable(), "Edit Profile"),
            Button(2, R.drawable.ic_address.toDrawable(), "Address"),
            Button(3, R.drawable.ic_notification.toDrawable(), "Notification"),
            Button(4, R.drawable.ic_payment.toDrawable(), "Payment"),
            Button(5, R.drawable.ic_security.toDrawable(), "Security"),
            Button(6, R.drawable.ic_language.toDrawable(), "Language"),
            Button(7, R.drawable.ic_dark_mode.toDrawable(), "Dark Mode", ButtonType.SWITCH),
            Button(8, R.drawable.ic_privacy_policy.toDrawable(), "Privacy Policy"),
            Button(9, R.drawable.ic_help_center.toDrawable(), "Help Center"),
            Button(10, R.drawable.ic_invite_friends.toDrawable(), "Invite Friends"),
            Button(11, R.drawable.ic_log_out.toDrawable(), "Logout"),
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val buttonsAdapter = ButtonRecyclerViewAdapter()
        binding.recyclerView.adapter = buttonsAdapter
        binding.recyclerView.setHasFixedSize(true)
        buttonsAdapter.setData(buttons)
    }
}