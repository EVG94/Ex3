package com.example.ex3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [StatisticFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StatisticFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val FragStat =   inflater.inflate(R.layout.fragment_statistic, container, false)

        val butINC:Button = FragStat.findViewById(R.id.btn_inc)
        val butDEC:Button = FragStat.findViewById(R.id.btn_dec)
        val tv1:TextView = FragStat.findViewById(R.id.tv_stat)
        var schet:Int = 1
        butINC.setOnClickListener {

            tv1.text = schet.toString()

            Toast.makeText(context, "+1  >> сделанных: $schet", Toast.LENGTH_SHORT).show()
            schet++
        }
        butDEC.setOnClickListener {
            tv1.text = schet.toString()

            Toast.makeText(context, "-1  >> сделанных: $schet", Toast.LENGTH_SHORT).show()
            schet--
        }










        return FragStat
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment StatisticFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            StatisticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}