package com.example.proyecto_pmmd.controller

import android.content.Context
import android.view.View
import android.widget.Toast
import com.example.proyecto_pmmd.LoginActivity
import com.example.proyecto_pmmd.dialogues.DialogLogin
import com.example.proyecto_pmmd.dialogues.DialogRegister
import com.example.proyecto_pmmd.fragments.ActivityIntentLogin

class Controller(private var context: Context) {
    fun setActionEvent() {
        val loginActivity = context as LoginActivity
        loginActivity.binding.idBtnLogin.setOnClickListener {
            initDialogLogin(loginActivity)
        }
        loginActivity.binding.idBtnRegister.setOnClickListener {
            initDialogRegister(loginActivity)
        }
    }

    private fun initDialogLogin(lA: LoginActivity) {
        val dialogLogin = DialogLogin(this, { username, password ->
            renderizeLogin(username, password)
        }, {
            msCancel(it)
        })
        dialogLogin.show(lA.supportFragmentManager, "Login")
    }

    private fun initDialogRegister(lA: LoginActivity) {
        val dialogRegister =
            DialogRegister(this, { fullname, email, username, password, confirmPassword ->
                renderizeRegister(fullname, email, username, password, confirmPassword)
            }, {
                msCancel(it)
            })
        dialogRegister.show(lA.supportFragmentManager, "Registrarse")
    }

    private fun renderizeRegister(
        fullname: String,
        email: String,
        username: String,
        password: String,
        confirmPassword: String
    ) {
        val registerAct = context as LoginActivity
        Toast.makeText(
            context, "Fullname: $fullname, " +
                    "Email: $email, " +
                    "Username: $username, Password: $password", Toast.LENGTH_SHORT
        ).show()
    }

    private fun renderizeLogin(username: String, password: String) {
        val loginAct = context as LoginActivity
        Toast.makeText(context, "Usuario: $username y Password: $password", Toast.LENGTH_LONG)
            .show()
    }

    private fun msCancel(msg: String) {
        Toast.makeText(context, "Has cancelado el login", Toast.LENGTH_LONG).show()
    }
}