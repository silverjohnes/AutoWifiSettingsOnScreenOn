package silver.johnes.autowifisettingsonscreenon

import android.content.BroadcastReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent

class ScreenReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_SCREEN_ON) {
            val networkIntent = Intent().apply {
                component = ComponentName(
                    "com.android.settings",
                    "com.android.settings.Settings\$NetworkDashboardActivity"
                )
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context?.startActivity(networkIntent)
        }
    }
}
