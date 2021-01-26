package com.example.ex3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.slide_item_container.view.*
import java.util.zip.Inflater

class PagerAdapter(private val context: Context, private val MyModelArrayList:ArrayList<MyModel>):PagerAdapter() {

    override fun getCount(): Int {
        return MyModelArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.slide_item_container, container, false)
        val model = MyModelArrayList[position]
        val title = model.title
        val description = model.decription
        val image = model.image
        view.bannerImg.setImageResource(image)
        view.titleImg.text = title
        view.titleDesc.text = description
        view.setOnClickListener {
            Toast.makeText(context, "$title \n $description \n ",Toast.LENGTH_SHORT).show()
        }

        container.addView(view,position-1)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}