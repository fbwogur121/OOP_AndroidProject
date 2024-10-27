package com.example.myhiapplication

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myhiapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater).apply {

        }

        fun replaceFragment(frag: Fragment) {
            // Fragment 설정
            supportFragmentManager.beginTransaction().run {
                replace(binding.frmFrag.id, InputFragment.newInstance())
                commit()
            }
        }

        binding.run {
            btnInput.setOnClickListener {
                replaceFragment(InputFragment.newInstance())
            }
            btnResult.setOnClickListener {
                replaceFragment(ResultFragment.newInstance(100))
            }
        }

        replaceFragment(InputFragment.newInstance())

        setContentView(binding.root)

//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        val hello = findViewById<TextView>(R.id.txtHello)
//        hello.setOnClickListener {
//            hello.text = "Hi, World!"
//        }

//        findViewById<TextView>(R.id.txtHello).run {
//            setOnClickListener {
//                text = "Hi, World!"
//                //
//            }
//        }

    }
}