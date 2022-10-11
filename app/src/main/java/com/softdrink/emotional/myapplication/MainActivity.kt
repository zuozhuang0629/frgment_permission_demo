package com.softdrink.emotional.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.softdrink.emotional.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var _vb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_vb.root)
        initView()
    }

    lateinit var currentFragment: Fragment
    val one = OneFragment()
    val two = TwoFragment()
    val three = ThreeFragment()
    fun initView() {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, one, "one")
        transaction.add(R.id.frameLayout, two, "two")
        transaction.add(R.id.frameLayout, three, "three")

        transaction.hide(two)
        transaction.hide(three)
        transaction.show(one)
        transaction.commit()
        currentFragment = one

        _vb.button.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (currentFragment != one) {
                transaction.hide(currentFragment)
                transaction.show(one)
                transaction.commit()

                currentFragment = one

            }

        }

        _vb.button2.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (currentFragment != two) {
                transaction.hide(currentFragment)
                transaction.show(two)
                transaction.commit()
                currentFragment = two
            }

        }
        _vb.button3.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (currentFragment != three) {
                transaction.hide(currentFragment)
                transaction.show(three)
                transaction.commit()
                currentFragment = three

            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == OneFragment.permissionCode) {// 判断请求码
            one.permissionResultCall(grantResults[0] == PackageManager.PERMISSION_GRANTED)
        }
    }
}