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
import com.example.pharmacy.API.APIBuild
import com.example.pharmacy.API.admin
import com.example.pharmacy.API.customer
import kotlinx.android.synthetic.main.fragment_sign_up.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignUp : Fragment() {
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
        var intent: Intent=Intent()
        var signupView=inflater.inflate(R.layout.fragment_sign_up, container, false)
        var type=  intent.getStringExtra("type")
        signupView.signUp.setOnClickListener {
            if(type=="patient"){
                var patient=customer(signupView.address.text.toString(),
                signupView.age.text.toString().toInt(),
                    signupView.dateRigester.text.toString(),
                    signupView.email.text.toString(),
                    signupView.password.text.toString(),
                    signupView.phone.text.toString(),
                    signupView.username.text.toString()
                    )
                var request= apiCall.add_customer(patient)
                request.enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code()==200)
                        {
                            intent=Intent(requireActivity(),home::class.java)
                            startActivity(intent)
                            Log.i(ContentValues.TAG,"${response.message()}")
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
                var doctor=admin(
                    signupView.address.text.toString(),
                    signupView.dateRigester.text.toString(),
                    signupView.email.text.toString(),
                    signupView.username.text.toString(),
                    signupView.password.text.toString(),
                    signupView.phone.text.toString(),
                )
                var request= apiCall.add_manager(doctor)
                request.enqueue(object : Callback<Unit> {
                    override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                        if (response.code()==200)
                        {
                            intent=Intent(requireActivity(),home::class.java)
                            startActivity(intent)
                            Log.i(ContentValues.TAG,"${response.message()}")
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

        }
        // Inflate the layout for this fragment
        return signupView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUp.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}