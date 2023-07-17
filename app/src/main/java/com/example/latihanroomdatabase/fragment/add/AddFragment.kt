package com.example.latihanroomdatabase.fragment.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.latihanroomdatabase.R
import com.example.latihanroomdatabase.viewmodel.UserViewModel
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.latihanroomdatabase.data.User


class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)

        //View model hubungkan
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val addButton: Button = view.findViewById(R.id.add_btn)
        val aadFirstName: TextView = view.findViewById(R.id.addFirstName_et)
        val aadLastName: TextView = view.findViewById(R.id.addLastName_et)
        val aadAge: TextView = view.findViewById(R.id.addAge_et)

        addButton.setOnClickListener {
            insertDataToDatabase()
        }


        return view
    }

    private fun insertDataToDatabase() {
        val addFirstName: EditText? = view?.findViewById(R.id.addFirstName_et)
        val firstName = addFirstName?.text.toString()

        val addLastName: EditText? = view?.findViewById(R.id.addLastName_et)
        val lastName = addLastName?.text.toString()

        val addAge: EditText? = view?.findViewById(R.id.addAge_et)
        val age = addAge?.text.toString()


        if (inputCheck(firstName, lastName, age)){
            // buat objek user
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            // tambahkan data ke database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Berhasil disimpan", Toast.LENGTH_LONG).show()

            // navigasi kembali
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Semua field harus diisi", Toast.LENGTH_LONG).show()
        }

    }


    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }


}