package com.example.myhiapplication

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.myhiapplication.databinding.ActivityMainBinding

val String.numOfKoreanCharacters : Int
    get(){
        var count = 0
        for ( i in 0 until length){
            if( this[i]>=0xAC00.toChar() && this[i]<=0xD7AF.toChar() ){
                count += 1
            }
        }
        return count
    }

class MainActivity : AppCompatActivity() {

    var text: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

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
                replaceFragment(ResultFragment.newInstance(text?.numOfKoreanCharacters ?: 0))
            }
        }

        supportFragmentManager.setFragmentResultListener("input_text", this) { _, bundle ->
            text = bundle.getString("input")
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