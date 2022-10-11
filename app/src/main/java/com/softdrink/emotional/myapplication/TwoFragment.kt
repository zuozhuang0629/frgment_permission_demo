package com.softdrink.emotional.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.softdrink.emotional.myapplication.databinding.FragmentTwoBinding

class TwoFragment : BaseFragment<FragmentTwoBinding>() {
    override fun initVB(): FragmentTwoBinding {
        return FragmentTwoBinding.inflate(layoutInflater)
    }

    override fun initSome() {
        _vb.btnTwo.setOnClickListener {
            requestPermission()
        }
    }

    val twoCode = 100
    val allPermission = arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    fun requestPermission() {
        if (ContextCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(
                this.requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(allPermission, OneFragment.permissionCode)

        } else {

            Toast.makeText(requireContext(), "TwoFragment Permissions granted", Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == twoCode) {

            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(
                    requireContext(),
                    "TwoFragment Permissions granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                Toast.makeText(
                    requireContext(),
                    "TwoFragment Permissions not granted",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }

    }
}