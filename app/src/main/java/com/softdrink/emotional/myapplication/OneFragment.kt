package com.softdrink.emotional.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.softdrink.emotional.myapplication.databinding.FragmentOneBinding

class OneFragment : BaseFragment<FragmentOneBinding>() {

    companion object {
        const val permissionCode = 100
    }

    override fun initVB(): FragmentOneBinding = FragmentOneBinding.inflate(layoutInflater)

    override fun initSome() {
        _vb.btnStart.setOnClickListener {
            requestPermission()
        }
    }

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
            requireActivity().requestPermissions(allPermission, permissionCode)

        } else {

            Toast.makeText(requireContext(), "OneFragment Permissions granted", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 权限的结果回调
     *
     * @param isOk 返回结果
     */
    fun permissionResultCall(isOk: Boolean) {
        Toast.makeText(
            requireContext(),
            if (isOk) " OneFragment Permissions granted" else "OneFragment Permissions not granted",
            Toast.LENGTH_SHORT
        ).show()
    }

}