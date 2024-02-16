package com.tisenres.urbaneyeapp.app.presentation.properties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.tisenres.urbaneyeapp.app.presentation.main.MainActivity
import com.tisenres.urbaneyeapp.databinding.FragmentPropertiesBinding

class PropertiesFragment : Fragment(), IPropertiesView {
    
    private lateinit var adapter: PropertiesAdapter
    private lateinit var binding: FragmentPropertiesBinding
    private lateinit var presenter: IPropertiesPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = PropertiesPresenter(this)
        adapter = PropertiesAdapter(presenter)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPropertiesBinding.inflate(layoutInflater)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }
    
    private fun initRecyclerView() {
        binding.propertiesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.propertiesRv.adapter = adapter
    }
    
    override fun navigateToInfoFragment() {
        val mainActivity = activity as? MainActivity
        mainActivity?.navigateToInfoFragment()
    }
}