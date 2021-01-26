package com.example.ex3

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_profile.*
import java.util.jar.Manifest

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private final val REQUEST_CODE_STORAGE = 1
    lateinit var sharedPref:SharedPreferences
    var isRemember = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)


        }

    }


    @SuppressLint("CommitPrefEdits")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val FragP =  inflater.inflate(R.layout.fragment_profile, container, false)

        val buttonSave = FragP.findViewById<Button>(R.id.btn_save)
        val buttonLoad = FragP.findViewById<Button>(R.id.btn_load)
        sharedPref = context?.getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)!!
        val editor = sharedPref.edit()
      //  isRemember = sharedPref.getBoolean("CHECKBOX", false)

        buttonSave.setOnClickListener {
            val name1:String = FragP.findViewById<EditText>(R.id.etName).text.toString()
            val age1:String = FragP.findViewById<EditText>(R.id.etAge).text.toString()
            val cheked1:Boolean = FragP.findViewById<CheckBox>(R.id.checkBox).isChecked
            val cheked2:Boolean = FragP.findViewById<CheckBox>(R.id.checkBox2).isChecked

            val name = name1
            val age = age1
            val checked = cheked1
            val checked2 = cheked2
            editor.putString("name", name)
              editor.putString("age", age)
                editor.putBoolean("check", checked)
            editor.putBoolean("check2", checked2)
            editor.apply()

            Toast.makeText(context, "Information saved", Toast.LENGTH_SHORT).show()
        }

        buttonLoad.setOnClickListener {
           val name:String? = sharedPref.getString("name","000")
          val age: String? = sharedPref.getString("age","null")
            val man:Boolean? = sharedPref.getBoolean("check",false)
            val woman:Boolean? = sharedPref.getBoolean("check2",false)
            etName.setText(name)
            etAge.setText(age)
            if (man != null) {
                checkBox.isChecked = man

            }
            checkBox2.isChecked  = woman!!

        }






        return FragP
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    fun selectImage(){



    }
}