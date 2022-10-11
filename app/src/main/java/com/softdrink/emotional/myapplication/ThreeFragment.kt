package com.softdrink.emotional.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.softdrink.emotional.myapplication.databinding.FragmentThreeBinding

class ThreeFragment : BaseFragment<FragmentThreeBinding>() {
    override fun initVB(): FragmentThreeBinding {
        return FragmentThreeBinding.inflate(layoutInflater)
    }

    override fun initSome() {
        _vb.btnThree.setOnClickListener {
            requestPermission()
        }
    }


    fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)

        } else {

            Toast.makeText(requireContext(), "ThreeFragment WRITE Permissions granted", Toast.LENGTH_SHORT)
                .show()
        }
    }

    //以接口的形式来进行回调的监听
    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(
                    requireContext(),
                    "ThreeFragment Permissions Granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "ThreeFragment Permissions Not Granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

}