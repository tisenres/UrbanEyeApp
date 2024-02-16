package com.tisenres.urbaneyeapp.app.presentation.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tisenres.urbaneyeapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment(), IInfoView {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var presenter: IInfoPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = InfoPresenter(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }
}