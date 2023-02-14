package com.example.pharmacy.Room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface DAO {
    @Insert
fun insertCustomer(customer: customer)
@Insert
fun insertAdmin(admin: admin)
@Insert
fun insertMedicine(medicine: medicine)
@Insert
fun logedPeople(logedin: logedin)
@Query("select * from customer_data where email= :mail")
fun getMyData(mail:String):customer
@Query("select * from `loged in` where email=:mail and password=:pass")
fun searchMe(mail: String,pass:String):logedin
}