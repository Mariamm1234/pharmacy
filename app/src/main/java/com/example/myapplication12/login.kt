package com.example.myapplication12

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.room.Room
import com.example.myapplication12.login
import com.example.pharmacy.API.APIBuild
import com.example.pharmacy.API.admin
import com.example.pharmacy.API.customer
import com.example.pharmacy.API.loginall
import com.example.pharmacy.Room.database
import com.example.pharmacy.Room.logedin
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [login.newInstance] factory method to
 * create an instance of this fragment.
 */
class login : Fragment() {
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
        val apiCall= APIBuild.buildServices()
        val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
         val STRING_LENGTH = 10
        // Inflate the layout for this fragment
        var intent: Intent= Intent()
        var loginView:View=inflater.inflate(R.layout.fragment_login, container, false)
      loginView.random.text= List(STRING_LENGTH) { charPool.random() }.joinToString("")
        var x=loginView.random.text.toString()
        var res=loginView.random_input.text.toString()
      var type=  intent.getStringExtra("type")
         loginView.login.setOnClickListener {

             if (res.equals(x))
             {
    if(type=="patient"){
        var patient= loginall(
            loginView.email1.text.toString(),
            loginView.password1.text.toString()
        )
        var rPat=logedin(loginView.email1.text.toString(),
            loginView.password1.text.toString())
        var request= apiCall.login_customer(patient)
        request.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code()==200)
                {
                    intent=Intent(requireActivity(),home::class.java)
                    startActivity(intent)
                    Log.i(ContentValues.TAG,"${response.message()}")
                    val dao = Room.databaseBuilder(activity!!.applicationContext,database::class.java,"database.name").build()
                    dao.getDao().logedPeople(rPat)



                }
                else{
                    Toast.makeText(context,"Error ", Toast.LENGTH_LONG).show()
                    Log.i(ContentValues.TAG,"${response.message()}")
                }

            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(context,"sign_up failed", Toast.LENGTH_LONG).show()
                Log.i(ContentValues.TAG, "${t.message}")
            }

        })
    }
    else if(type=="doctor")
    {
        var doctor= loginall(
            loginView.email1.text.toString(),
            loginView.password1.text.toString()
        )
        var rDoctor= logedin(loginView.email1.text.toString(),
            loginView.password1.text.toString())
        var request= apiCall.login_manager(doctor)
        request.enqueue(object : Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                if (response.code()==200)
                {
                    intent=Intent(requireActivity(),home::class.java)
                    startActivity(intent)
                    Log.i(ContentValues.TAG,"${response.message()}")
                    val dao = Room.databaseBuilder(activity!!.applicationContext,database::class.java,"database.name").build()
                    dao.getDao().logedPeople(rDoctor)
                }
                else{
                    Toast.makeText(context,"Error ", Toast.LENGTH_LONG).show()
                    Log.i(ContentValues.TAG,"${response.message()}")
                }

            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                Toast.makeText(context,"sign_up failed", Toast.LENGTH_LONG).show()
                Log.i(ContentValues.TAG, "${t.message}")
            }

        })
    }

                 intent=Intent(requireActivity(),home::class.java)
            startActivity(intent)}
             else
             {   Toast.makeText(context,"you entered wrong answer",Toast.LENGTH_LONG).show()
             }
        }

        return loginView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment login.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            login().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}