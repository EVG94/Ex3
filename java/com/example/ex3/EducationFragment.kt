package com.example.ex3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EducationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EducationFragment : Fragment() {
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
       val FragE =  inflater.inflate(R.layout.fragment_education, container, false)

        val btn_add:Button = FragE.findViewById(R.id.btn_insert)
        val btn_read:Button = FragE.findViewById(R.id.btnLoad)
        val btn_update:Button = FragE.findViewById(R.id.btnUpdate)
        val btn_deleted:Button = FragE.findViewById(R.id.btnDelete)
        var et1:EditText = FragE.findViewById(R.id.etvName)
        var tv1:TextView = FragE.findViewById(R.id.tvResult)
        var et2:EditText = FragE.findViewById(R.id.etvAge)
        var db = DatabaseHandler(requireContext())

        btn_add.setOnClickListener {
            if (et1.text.toString().isNotEmpty() && et2.text.toString().isNotEmpty()){

                var user = User(et1.text.toString(), et2.text.toString().toInt())
               // var db = context?.let { it1 -> DatabaseHandler(it1) }
                db.insertData(user)

            }else{

                Toast.makeText(context, "Pls check in ALL FIELD", Toast.LENGTH_SHORT).show()
            }

        }
        btn_read.setOnClickListener {
            var data = db.readData()
            tv1.text =""
            for (i in 0 until data.size){

                tv1.append(data.get(i).id.toString() + " " + data.get(i).name + " " + data.get(i).age + "\n")
            }
        }
        btn_update.setOnClickListener {
            db.updateData()
            btn_read.performClick()
        }
        btn_deleted.setOnClickListener {
            db.deleteData()
            btn_read.performClick()
        }





        return FragE
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EducationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EducationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}