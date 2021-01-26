package com.example.ex3

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_alert_dialog.*

class AlertDialogActivity : AppCompatActivity() {

    override fun onBackPressed() {
        createMultiItemDialog()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

       createMultiItemDialog()


    }
    private fun createSimpleDialog(){

        val builder = AlertDialog.Builder(this)
        builder.setTitle("This is my AlertDialog")
        builder.setMessage("This is my")
        //действия при нажатии на диалог
        builder.setNeutralButton("My info", DialogInterface.OnClickListener { dialogInterface, i ->



        })
        builder.setNegativeButton("NO"){dialog, i->

        }
        builder.setPositiveButton("Apply"){dialog, i ->


        }
        builder.show()


    }
    private fun createMultiItemDialog(){

        val ListOfChoise: Array<String> = arrayOf("AUDI", "BMW", "MERCEDES")
        var myArray:Array<String> = arrayOf()
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.statistic)
        builder.setTitle("What car respect for you")

        builder.setMultiChoiceItems(ListOfChoise, null ){ dialog, position, choise ->




                for (i in ListOfChoise.indices){
                   when(position){

                       0 -> if (choise){ tv_dialog.text = ListOfChoise[0]} else tv_dialog.text =""
                       1 -> if (choise){ tv_dialog3.text = ListOfChoise[1]} else tv_dialog3.text =""
                       2 -> if (choise){ tv_dialog4.text = ListOfChoise[2]} else tv_dialog4.text =""


                   }



            }

        }
        //действия при нажатии на диалог
        builder.setNeutralButton("My info", DialogInterface.OnClickListener { dialogInterface, i ->

            tv_dialog2.text = "Date : 23/12/2020"


        })
        builder.setNegativeButton("NO"){dialog, i->
            finish()

        }
        builder.setPositiveButton("Apply"){dialog, i ->




        }
        builder.show()


    }
}