package com.example.ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : AppCompatActivity() {
    private lateinit var actionBar:ActionBar
    private lateinit var myModelList:ArrayList<MyModel>
    private lateinit var myAdapter: PagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

      //  actionBar = this.supportActionBar!!
        loadCars()
        viewPagerImageSlider.addOnAdapterChangeListener(object : ViewPager.OnPageChangeListener,
            ViewPager.OnAdapterChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                val title = myModelList[position].title
                actionBar.title = title
            }

            override fun onPageSelected(position: Int) {

            }

            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onAdapterChanged(
                viewPager: ViewPager,
                oldAdapter: androidx.viewpager.widget.PagerAdapter?,
                newAdapter: androidx.viewpager.widget.PagerAdapter?
            ) {

            }
        })
    }

    private fun loadCars() {
        myModelList = ArrayList()
        myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.audi_one))
        myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.audi_two))
       myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.merc_one))
      //  myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.merc_two))
       // myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.bmw_one))
        myModelList.add(MyModel("Top Cars", "This is very speed monsters in world", R.drawable.bmw_two))
        myAdapter = PagerAdapter(this, myModelList)
        viewPagerImageSlider.adapter = myAdapter
    }
}