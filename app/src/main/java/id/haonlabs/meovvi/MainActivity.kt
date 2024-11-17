package id.haonlabs.meovvi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import id.haonlabs.meovvi.data.Person
import id.haonlabs.meovvi.ui.ProfileActivity

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.activity_main)

    val name: EditText = findViewById(R.id.etName)
    val job: EditText = findViewById(R.id.etJob)
    val age: EditText = findViewById(R.id.etAge)
    val btnNext: Button = findViewById(R.id.btnNext)

    btnNext.setOnClickListener {
      val person = Person(name.text.toString(), job.text.toString(), age.text.toString().toInt())
      val intent = Intent(this@MainActivity, ProfileActivity::class.java)
      intent.putExtra(ProfileActivity.EXTRA_PERSON, person)
      startActivity(intent)
    }
  }
}
