package com.mvvm.view.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.mvvm.R
import com.mvvm.data.dataclass.PokemonData
import com.mvvm.databinding.PokemonListItemBinding
import com.mvvm.util.ext.*

class PokemonAdapter(private val context: Context): RecyclerView.Adapter<PokemonAdapter.VH>() {

    private var listData: List<PokemonData>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(listData?.get(position)!!, context)
//        val data = listData?.get(position)!!
    }

    override fun getItemCount(): Int {
        if (listData == null) return 0
        else return listData?.size!!
    }

    class VH(view: PokemonListItemBinding) : RecyclerView.ViewHolder(view.root) {
        val dym = view.dynamicLayout
        val img = view.imgView
        val progress = view.progressBar
        val txtName = view.pokemonName
        val txtNumber = view.pokemonID

        fun bind(data: PokemonData, context: Context){
            var dominantColor = 0
            var id_ =""
            var extractId = data.url.extractId()
            if (extractId < 10){
                id_ = "#00${extractId}"
            }else if(extractId < 100){
                id_ = "#0${extractId}"
            }else{
                id_ = "#${extractId}"
            }

            var url = data.url.getPicUrl()
            Glide.with(img)
                .load(url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        progress.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        val drawable = resource as BitmapDrawable
                        val bitmap = drawable.bitmap
                        Palette.Builder(bitmap).generate {
                            it?.let { palette ->
                                dominantColor = palette.getDominantColor(ContextCompat.getColor(context, R.color.colorWhite))
                            }
                            img.setBackgroundColor(dominantColor)
                        }
                        progress.visibility = View.GONE
                        return false
                    }
                })
                .into(img)

            txtName.text = "${(data.name).capitalize()}"
            txtNumber.text = "${id_}"

        }
    }

    fun swap(listData: List<PokemonData>?) {
        this.listData = listData
    }
}