package com.tisenres.urbaneyeapp.app.presentation.info

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.tisenres.urbaneyeapp.R
import com.tisenres.urbaneyeapp.databinding.FragmentInfoBinding

class InfoFragment : Fragment(), IInfoView, OnMapReadyCallback {
    private lateinit var binding: FragmentInfoBinding
    private lateinit var presenter: IInfoPresenter
    private var mMap: GoogleMap? = null
    
    private val REQUEST_CALL_PHONE = 1
    
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
        
        binding.mapView.onCreate(savedInstanceState)
        binding.mapView.getMapAsync(this)
        
        setOnClickListeners()
    }
    
    private fun setOnClickListeners() {
        binding.sosButton.setOnClickListener {
            callEmergency()
        }
    }
    
    override fun onPause() {
        super.onPause()
        if (binding.videoView.isPlaying) {
            binding.videoView.pause()
        }
        binding.mapView.onPause()
    }
    
    override fun onResume() {
        super.onResume()
        if (!binding.videoView.isPlaying) {
            binding.videoView.start()
        }
        binding.mapView.onResume()
    }
    
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val markerLocation = LatLng(41.298423, 69.277392)
        
        mMap!!.addMarker(MarkerOptions().position(markerLocation).title("Marker in Tashkent"))
        val zoomLevel = 15.0f
        
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(markerLocation, zoomLevel))
    }
    
    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }
    
    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }
    
    private fun callEmergency() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CALL_PHONE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                requireContext() as Activity,
                arrayOf(Manifest.permission.CALL_PHONE),
                REQUEST_CALL_PHONE
            )
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:112")
            startActivity(intent)
        }
    }
    
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        if (requestCode == REQUEST_CALL_PHONE) {
//            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                callEmergency()
//            } else {
//                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
    
}