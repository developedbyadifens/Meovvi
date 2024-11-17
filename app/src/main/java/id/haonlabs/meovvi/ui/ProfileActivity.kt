package id.haonlabs.meovvi.ui

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import id.haonlabs.meovvi.R
import id.haonlabs.meovvi.data.Person

class ProfileActivity : AppCompatActivity() {
  companion object {
    const val EXTRA_PERSON = "extra_person"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_profile)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }

    val personData =
        if (Build.VERSION.SDK_INT >= 33) {
          intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        } else {
          @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_PERSON)
        }

    val tvName: TextView = findViewById(R.id.tvName)
    val tvJob: TextView = findViewById(R.id.tvJob)
    val tvAge: TextView = findViewById(R.id.tvAge)

    tvName.text = personData?.name ?: "not set"
    tvJob.text = personData?.job ?: "not set"
    tvAge.text = (personData?.age ?: "not set").toString()
  }
}
