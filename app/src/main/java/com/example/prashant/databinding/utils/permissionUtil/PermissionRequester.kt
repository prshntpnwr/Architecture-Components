package com.example.prashant.databinding.utils.permissionUtil

import android.app.Activity
import android.content.Context
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment

class PermissionRequester(owner: Any) {
    private val mOwner: Any = owner
    private val context: Context = when (owner) {
        is Activity -> owner
        else -> (owner as Fragment).requireContext()
    }

    fun requestPermission(permissions: Array<String>, grantResults: Int) {
        when (mOwner) {
            is Activity -> requestPermissions(mOwner, permissions, grantResults)
            is Fragment -> mOwner.requestPermissions(permissions, grantResults)
        }
    }

    fun isGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(context, permission) == PermissionChecker.PERMISSION_GRANTED
    }
}