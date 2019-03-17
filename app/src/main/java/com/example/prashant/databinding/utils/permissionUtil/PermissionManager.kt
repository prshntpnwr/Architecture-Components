package com.example.prashant.databinding.utils.permissionUtil

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import com.example.prashant.databinding.utils.permissionUtil.PermissionPriority.Companion.PERMISSION_HIGH
import com.example.prashant.databinding.utils.permissionUtil.PermissionPriority.Companion.PERMISSION_LOW

class PermissionManager : ComponentLifecycleObserver, PermissionDelegate {
    private val requestMap = HashMap<Int, PermissionPriority>()
    private val pendingResults = HashMap<Int, PermissionResult>()

    private lateinit var permissionRequester: PermissionRequester<*>

    override fun <T> initWith(owner: T) {
        permissionRequester = PermissionRequester(owner)
    }

    fun onRequestPermissionsResult(
            requestCode: Int,
            permissions: Array<out String>,
            grantResults: IntArray
    ) {
        if (requestMap.containsKey(requestCode))
            pendingResults[requestCode] = PermissionResult(
                    permissionHandler = requestMap.remove(requestCode)!!,
                    resultPermissions = permissions,
                    grantResult = grantResults)
    }

    override fun requestAndRun(
            permissions: List<String>,
            failAction: ((List<String>) -> Unit)?,
            action: (() -> Unit)?
    ) {
        request(permissions, PermissionPriority.create(PERMISSION_LOW, failAction, action), action)
    }

    override fun requestThenRun(
            permissions: List<String>,
            failAction: ((List<String>) -> Unit)?,
            action: (() -> Unit)?
    ) {
        request(permissions, PermissionPriority.create(PERMISSION_HIGH, failAction, action), action)
    }

    private fun request(
            permissions: List<String>,
            handler: PermissionPriority,
            action: (() -> Unit)?
    ) {
        val notGrantedPermissions = ArrayList(permissions.filterNot { permissionRequester.isGranted(it) })
        val permissionArray = notGrantedPermissions.toTypedArray()

        if (permissionArray.isEmpty()) {
            action?.invoke()
        } else {
            val id = Math.abs(handler.hashCode().toShort().toInt())
            requestMap[id] = handler
            permissionRequester.requestPermission(permissionArray, id)
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        for ((_, result) in pendingResults) result.onPermissionResult()
        pendingResults.clear()
    }

    private inner class PermissionResult constructor(
            private val permissionHandler: PermissionPriority,
            private val resultPermissions: Array<out String>,
            private val grantResult: IntArray
    ) {
        fun onPermissionResult() = permissionHandler.onPermissionResult(
                resultPermissions, grantResult)
    }
}