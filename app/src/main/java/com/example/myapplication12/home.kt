package com.example.myapplication12

import android.content.Intent
import android.os.Bundle
import android.os.Process
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    lateinit var toogle:ActionBarDrawerToggle
    lateinit var drawable:DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)
        var intent:Intent
         drawable=findViewById(R.id.drawerlayout)
        var navBar:NavigationView=findViewById(R.id.nav_view)
        toogle= ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close)
        drawerlayout.addDrawerListener(toogle)
        toogle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navBar.setNavigationItemSelectedListener {
            it.isChecked=true
            val actionBar = supportActionBar
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(drawable.background)
            }
            when(it.itemId)
            {
                R.id.logout->{
                    val alert=  AlertDialog.Builder(this)
                    alert.apply {
                        setMessage("Do you want to logout??")
                        setTitle("Logout Assurance")
                        setPositiveButton("Yes"){ dialog,id->
                            intent= Intent(this@home,splash::class.java)
                            intent.putExtra("isloged","false")
                            setResult(RESULT_OK,intent)
                            //to quit app totaly
                            moveTaskToBack(true);
                            finish()
//                            val pid = Process.myPid()
//                            Process.killProcess(pid)
//                             intent = Intent(Intent.ACTION_MAIN)
//                            intent.addCategory(Intent.CATEGORY_HOME)
//                            startActivity(intent)
                        }
                        setNegativeButton("No"){dialog,id->}

                    }
                    alert.show()
                }
                R.id.edit-> {replaceFragments(EditProfile(),it.title.toString())
                   Log.i("lol",it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.p_prescription->{replaceFragments(MyPrescription(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.p_medicine->{replaceFragments(MyMedicines(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.image->{replaceFragments(AddImage(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.prescription->{replaceFragments(write_one(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.d_prescription->{replaceFragments(AllPrescriptions(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.d_medicine->{replaceFragments(AllMedicines(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.doctors->{replaceFragments(AllDoctors(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.patient->{replaceFragments(AllCustomers(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.comprescription->{replaceFragments(complete_one(),it.title.toString())
                    actionBar!!.title = it.title.toString()
                }
                R.id.chat->Toast.makeText(this,"not supported in this virsion",Toast.LENGTH_LONG).show()
            }
            true }


    }

    override fun onResume() {
        super.onResume()
        getSupportActionBar()?.show()
    }

    private fun replaceFragments(fragment:Fragment,title:String)
{
    val fragmentManager=supportFragmentManager
    val fragmentTransaction=fragmentManager.beginTransaction()
    fragmentTransaction.replace(R.id.framelayout,fragment)
    fragmentTransaction.commit()
    drawable.closeDrawers()
    setTitle(title)
}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item))
        {return true}
        return super.onOptionsItemSelected(item)
    }
}