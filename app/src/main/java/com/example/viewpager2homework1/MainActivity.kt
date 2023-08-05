package com.example.viewpager2homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.viewpager2homework1.adapters.ViewPager2Adapter
import com.example.viewpager2homework1.databinding.ActivityMainBinding
import com.example.viewpager2homework1.databinding.ItemTabLayoutBinding
import com.example.viewpager2homework1.databinding.ItemViewPagerBinding
import com.example.viewpager2homework1.models.User
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var list:ArrayList<User>
    lateinit var adapter: ViewPager2Adapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        loadData()
        adapter = ViewPager2Adapter(list)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { _, _ ->

        }.attach()
        val currentItem = binding.viewPager2.currentItem

        binding.materialButton.setOnClickListener {
            if (currentItem < list.size - 1) {
                binding.viewPager2.setCurrentItem(list.size, true)
            }
        }

    }

    private fun loadData() {
        list = ArrayList()
        list.add(User(R.drawable.img,"Xush kelibsiz", "Kim ko‘rubdur, ey ko‘ngul, ahli jahondin yaxshilig‘ Kimki, ondin yaxshi yo‘q, ko‘z tutma ondin yaxshilig"))
        list.add(User(R.drawable.img1,"Hikoyalar dunyosi", "Gar zamonni nayf qilsam ayb qilma, ey rafiq,Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘ ! "))
        list.add(User(R.drawable.img2,"Kitob ortidan...", "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,Kelmadi jonimg'a hech oromi jondin yaxshilig'."))
        list.add(User(R.drawable.img3,"Bizga qo'shiling", "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p, Endi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?"))
    }
}