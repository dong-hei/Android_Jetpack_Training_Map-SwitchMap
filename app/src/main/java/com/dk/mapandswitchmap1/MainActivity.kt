package com.dk.mapandswitchmap1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dk.mapandswitchmap1.databinding.ActivityMainBinding

/**
 * LiveData Transformations
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        vm.liveCount.observe(this, Observer {
            //이런 식으로 표현하는게 좋은 방법은 아니다.
//            binding.resultArea1.text = (it+it).toString()
//            binding.resultArea2.text = (it*it).toString()
        })

        vm.mapLiveData.observe(this, Observer{
            binding.resultArea1.text = it.toString()

        })
        vm.switchMapLiveData.observe(this, Observer {
            binding.resultArea2.text = it.toString()
        })

        binding.btnArea.setOnClickListener {
            val count = binding.inputArea.text.toString().toInt()
            vm.setLiveDataVal(count)
        }
    }
}