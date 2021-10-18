package com.mvvm.util.ext

import android.content.Context
import android.util.TypedValue
import android.widget.Toast
import com.mvvm.R
import com.mvvm.util.Constants

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun String.extractId() = this.substringAfter("pokemon").replace("/", "").toInt()

fun Float.toDip(context: Context): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, context.resources.displayMetrics).toInt()
}

fun String.getPicUrl(): String {
    val id = this.extractId()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
}

fun String.getColor(): Int {
    var color = R.color.colorNormal
    when(this){
        Constants.NORMAL -> {color = R.color.colorNormal}
        Constants.FIRE -> {color = R.color.colorFire}
        Constants.WATER -> {color = R.color.colorWater}
        Constants.ELECTRIC -> {color = R.color.colorElectric}
        Constants.GRASS -> {color = R.color.colorGrass}
        Constants.ICE -> {color = R.color.colorIce}

        Constants.FIGHTING -> {color = R.color.colorFighting}
        Constants.POISON -> {color = R.color.colorPoison}
        Constants.GROUND -> {color = R.color.colorGround}
        Constants.FLYING -> {color = R.color.colorFlying}
        Constants.PSYCHIC -> {color = R.color.colorPsychic}
        Constants.BUG -> {color = R.color.colorBug}

        Constants.ROCK -> {color = R.color.colorRock}
        Constants.GHOST -> {color = R.color.colorGhost}
        Constants.DRAGON -> {color = R.color.colorDragon}
        Constants.DARK -> {color = R.color.colorDark}
        Constants.STEEL -> {color = R.color.colorSteel}
        Constants.FAIRY -> {color = R.color.colorFairy}
    }
    return color

}