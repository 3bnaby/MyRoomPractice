package com.example.myroompractice.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myroompractice.R
import com.example.myroompractice.data.User
import com.example.myroompractice.data.UserViewModel
import com.example.myroompractice.databinding.FragmentAddBinding

class AddFragment:Fragment() {
    lateinit var binding:FragmentAddBinding
    private lateinit var mUserViewModel :UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.button.setOnClickListener {
            insertDataToDatabase()
        }
    }
    private fun insertDataToDatabase(){
        val firstName = binding.editTextTextPersonName.text.toString()
        val lastName = binding.editTextTextPersonName2.text.toString()
        val age = binding.editTextTextPersonName3.text

        if (inputCheck(firstName,lastName,age)){
            val user =User(0,firstName,lastName,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Add Done" , Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields" , Toast.LENGTH_SHORT).show()

        }


    }
    private fun inputCheck(firstName:String, lastName:String, age:Editable):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
}