package id.haonlabs.meovvi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.haonlabs.meovvi.R
import id.haonlabs.meovvi.adapter.ListGalleryAdapter.ListGalleryViewHolder
import id.haonlabs.meovvi.data.Gallery

class ListGalleryAdapter(private val listGallery: ArrayList<Gallery>) :
    RecyclerView.Adapter<ListGalleryViewHolder>() {

  class ListGalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListGalleryViewHolder {
    val view: View =
        LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
    return ListGalleryViewHolder(view)
  }

  override fun getItemCount(): Int = listGallery.size

  override fun onBindViewHolder(holder: ListGalleryViewHolder, position: Int) {
    val (imgUrl) = listGallery[position]
    //    holder.imgPhoto.setImageResource(imgUrl)
    Glide.with(holder.itemView.context).load(imgUrl).into(holder.imgPhoto)
  }
}
