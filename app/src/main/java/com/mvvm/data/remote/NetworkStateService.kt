package com.mvvm.data.remote

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import com.mvvm.data.remote.model.Conectivity
import org.greenrobot.eventbus.EventBus

class NetworkStateService: BroadcastReceiver() {
    protected var connected: Boolean? = null

    override fun onReceive(context: Context, intent: Intent?) {
        if (intent == null || intent.extras == null)
            return

        val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val ni = manager.activeNetworkInfo

        if (ni != null && ni.state == NetworkInfo.State.CONNECTED) {
            connected = true
        } else if (intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, java.lang.Boolean.FALSE)) {
            connected = false
        } else if (ni != null && ni.state == NetworkInfo.State.DISCONNECTED){
            connected = false
        } else if (ni == null){
            connected = false
        }

        notifyState()
    }

    private fun notifyState() {
        var connect = Conectivity()
        if (connected == null)
            return

        if (connected == true)
            connect.isConnect = true
        else{
            connect.isConnect = false
        }
        EventBus.getDefault().post(connect)
    }
}