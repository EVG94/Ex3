package com.example.ex3

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import com.airbnb.lottie.LottieAnimationView


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SettingsFragment : Fragment() {
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
        val FragS = inflater.inflate(R.layout.fragment_settings, container, false)

        val buttonInternet: Button = FragS.findViewById(R.id.btn_check_internet)
        val buttonDialog:Button = FragS.findViewById(R.id.btn_dialog)
        val buttonCompass:Button = FragS.findViewById(R.id.btn_kompass)
        val buttonPager:Button = FragS.findViewById(R.id.btn_pager2)
        val buttonScratch:Button = FragS.findViewById(R.id.btn_scratch)
        buttonInternet.setOnClickListener {

            val intent = Intent(this.context, NetworkActivity::class.java)
            startActivity(intent)
        }
        buttonDialog.setOnClickListener {

            val intent = Intent(this.context, AlertDialogActivity::class.java)
            startActivity(intent)
        }
        buttonCompass.setOnClickListener {
            val intent = Intent(this.context, CompassActivity::class.java)
            startActivity(intent)
        }
        buttonPager.setOnClickListener {
            val intent = Intent(this.context, PagerActivity::class.java)
            startActivity(intent)
        }
        buttonScratch.setOnClickListener {
            val intent = Intent(this.context, ScratchActivity::class.java)
            startActivity(intent)
        }











        return FragS
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SettingsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SettingsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}