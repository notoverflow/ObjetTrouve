package com.example.objetceri


import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.objetceri.databinding.FragmentPopUpBinding
import com.google.firebase.auth.FirebaseAuth


class PopUpFragment : DialogFragment() {

    private lateinit var binding: FragmentPopUpBinding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_pop_up, container, false)
    }

 
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val actions = view.findViewById<LinearLayout>(R.id.actions) // form for actions
        val btnLogIn = view.findViewById<Button>(R.id.btnLogIn) // btn for show log in form
        val btnSignUp = view.findViewById<Button>(R.id.btnSignUp) // btn for show sign Up form


        val logIn = view.findViewById<LinearLayout>(R.id.logIn) // form for log in
        val LogUsername = view.findViewById<EditText>(R.id.LogUsername) // form for log in
        val LogPassword = view.findViewById<EditText>(R.id.LogPassword) // form for log in
        val LogIn = view.findViewById<Button>(R.id.LogIn) // button for log in


        val signUp = view.findViewById<LinearLayout>(R.id.signUp) // form for sign up
        val SignUsername = view.findViewById<EditText>(R.id.SignUsername) // form for sign up
        val SignEmail = view.findViewById<EditText>(R.id.SignEmail) // form for sign up
        val SignPassword = view.findViewById<EditText>(R.id.SignPassword) // form for sign up
        val SignPasswordConfirm = view.findViewById<EditText>(R.id.SignPasswordConfirm) // form for sign up
        val SignUp = view.findViewById<Button>(R.id.SignUp) // button for sign up


        btnLogIn.setOnClickListener()
        {
            logIn.visibility = View.VISIBLE
            actions.visibility = View.INVISIBLE

        }
        btnSignUp.setOnClickListener()
        {
            signUp.visibility = View.VISIBLE
            actions.visibility = View.INVISIBLE
        }



        firebaseAuth = FirebaseAuth.getInstance()

        SignUp.setOnClickListener{

            val mail = SignEmail.text.toString()
            val password = SignPassword.text.toString()
            val passwordConfirm = SignPasswordConfirm.text.toString()


            if(mail.isNotEmpty() && password.isNotEmpty() && passwordConfirm.isNotEmpty())
            {
                if (password == passwordConfirm) {
                    firebaseAuth.createUserWithEmailAndPassword(mail, password)
                        .addOnCompleteListener()
                        {
                            if (it.isSuccessful) {

                                Toast.makeText(requireActivity(), "User created", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                            }
                        }
                } else {
                    Toast.makeText(requireActivity(), "Password is not matching", Toast.LENGTH_SHORT).show()

                }
            }
            else
            {
                actions.visibility = View.VISIBLE
                signUp.visibility = View.INVISIBLE
            }


        }

        LogIn.setOnClickListener{

            val mail = LogUsername.text.toString()
            val password = LogPassword.text.toString()

            if(mail.isNotEmpty() && password.isNotEmpty())
            {
                firebaseAuth.signInWithEmailAndPassword(mail, password)
                    .addOnCompleteListener()
                    {
                        if (it.isSuccessful) {

                            Toast.makeText(requireActivity(), "User logged in", Toast.LENGTH_SHORT).show()
                        } else {
                            Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
            else
            {
                actions.visibility = View.VISIBLE
                logIn.visibility = View.INVISIBLE
            }

        }


    }


}
