package com.tisenres.urbaneyeapp.app.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.tisenres.urbaneyeapp.app.presentation.info.InfoFragment
import com.tisenres.urbaneyeapp.app.presentation.properties.PropertiesFragment
import com.tisenres.urbaneyeapp.data.WebSocketClient
import com.tisenres.urbaneyeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        navigateToPropertiesFragment()
        val webSocketClient = WebSocketClient()
        webSocketClient.connectWebSocket()
    }
    
    private fun navigateToPropertiesFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, android.R.anim.fade_out)
            setReorderingAllowed(true)
            replace<PropertiesFragment>(containerViewId = binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }
    
    fun navigateToInfoFragment() {
        supportFragmentManager.commit {
            setCustomAnimations(androidx.appcompat.R.anim.abc_fade_in, android.R.anim.fade_out)
            setReorderingAllowed(true)
            replace<InfoFragment>(containerViewId = binding.fragmentContainer.id)
            addToBackStack(null)
        }
    }
}