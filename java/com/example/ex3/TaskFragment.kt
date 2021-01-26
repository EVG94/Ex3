package com.example.ex3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_task.*
import java.util.ArrayList


class TaskFragment:Fragment() {

    private val movieList = ArrayList<Model>()
    private lateinit var moviesAdapter: MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val Frag:View = layoutInflater.inflate(R.layout.fragment_task, container, false)

        val MyrecyclerView: RecyclerView = Frag.findViewById(R.id.my_recyclerView)
        val addButt = Frag.findViewById<Button>(R.id.btn_add)

        val et1 = Frag.findViewById<EditText>(R.id.edit_text)
        val et2 = Frag.findViewById<EditText>(R.id.edit_text2)
        moviesAdapter = MyAdapter(movieList)
        val layoutManager = LinearLayoutManager(context)
        MyrecyclerView.layoutManager = layoutManager
        MyrecyclerView.itemAnimator = DefaultItemAnimator()
        MyrecyclerView.adapter = moviesAdapter
     //   prepareMovieData()

        addButt.setOnClickListener {
            val movieString:String = edit_text.text.toString()
            val movie2String:String = edit_text2.text.toString()
            val movie = Model(movieString, "Deadline of : $movie2String")
            movieList.add(movie)
            //  moviesAdapter.notifyItemInserted(id)
            et1.setText("")
            et2.setText("")
            moviesAdapter.notifyDataSetChanged()
        }


        val itemTouchHelper = ItemTouchHelper(SwipeToDelete(moviesAdapter))
        itemTouchHelper.attachToRecyclerView(MyrecyclerView)




        return Frag
    }

  /*  private fun prepareMovieData() {
        var movie = Model("Action & Adventure", "2015")
        movieList.add(movie)
        movie = Model("Inside Out", "Animation, Kids & Family")
        movieList.add(movie)

    }

   */

}