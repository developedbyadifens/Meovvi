package id.haonlabs.meovvi

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.haonlabs.meovvi.adapter.ListGalleryAdapter
import id.haonlabs.meovvi.data.Gallery

class MainActivity : AppCompatActivity() {
  private lateinit var rvGallery: RecyclerView
  private val list = ArrayList<Gallery>()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    rvGallery = findViewById(R.id.rv_galleries)
    rvGallery.setHasFixedSize(true)
    //    showRecyclerList()

    //    list.addAll(getListGallery())

    val etImgUrl: EditText = findViewById(R.id.et_img_url)
    val btnAdd: Button = findViewById(R.id.btn_add_url)
    btnAdd.setOnClickListener {
      list.add(Gallery(etImgUrl.text.toString()))
      etImgUrl.text.clear()
      showRecyclerList()
    }
  }

  private fun getListGallery(): ArrayList<Gallery> {
    val listGallery = ArrayList<Gallery>()
    for (i in 1..5) {
      listGallery.add(
          Gallery("https://images.bisnis.com/posts/2022/05/10/1531602/avatar-the-way-of-water.jpg"))
    }
    return listGallery
  }

  private fun showRecyclerList() {
    rvGallery.layoutManager = GridLayoutManager(this, 2)
    val listGalleryAdapter = ListGalleryAdapter(list)
    rvGallery.adapter = listGalleryAdapter
  }
}
