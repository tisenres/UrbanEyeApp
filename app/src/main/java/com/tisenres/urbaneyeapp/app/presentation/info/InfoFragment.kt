package com.tisenres.urbaneyeapp.app.presentation.info

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tisenres.urbaneyeapp.R
import com.tisenres.urbaneyeapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment(), IInfoView {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var presenter: IInfoPresenter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = InfoPresenter(this)
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(layoutInflater)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoPath = "android.resource://${requireActivity().packageName}/${R.raw.fire_video}"
        binding.videoView.setVideoURI(Uri.parse(videoPath))
        binding.videoView.start()
    }
    
    override fun onPause() {
        super.onPause()
        if (binding.videoView.isPlaying) {
            binding.videoView.pause()
        }
    }
    
    override fun onResume() {
        super.onResume()
        if (!binding.videoView.isPlaying) {
            binding.videoView.start()
        }
    }
}