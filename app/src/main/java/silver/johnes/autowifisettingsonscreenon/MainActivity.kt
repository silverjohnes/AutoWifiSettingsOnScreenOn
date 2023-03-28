package silver.johnes.autowifisettingsonscreenon

import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var toggle: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Регистрация BroadcastReceiver для отслеживания включения экрана
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        val receiver = ScreenReceiver()
        registerReceiver(receiver, filter)

        // Добавление настройки "Вкл/выкл"
        toggle = findViewById(R.id.toggle)
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        toggle.isChecked = sharedPreferences.getBoolean("enabled", true)
        toggle.setOnCheckedChangeListener { _, isChecked ->
            sharedPreferences.edit().putBoolean("enabled", isChecked).apply()
        }
    }
}
