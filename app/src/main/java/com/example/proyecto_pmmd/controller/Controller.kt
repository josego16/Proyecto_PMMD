package com.example.proyecto_pmmd.controller

import android.content.Context
import android.widget.Toast
import com.example.proyecto_pmmd.LoginActivity
import com.example.proyecto_pmmd.MainActivity
import com.example.proyecto_pmmd.adapter.AdapterDigimon
import com.example.proyecto_pmmd.dao.DaoDigimons
import com.example.proyecto_pmmd.dialogues.DialogLogin
import com.example.proyecto_pmmd.dialogues.DialogRegister
import com.example.proyecto_pmmd.models.Digimon

class Controller(private var context: Context) {
    private lateinit var listDigimons: MutableList<Digimon>
    private lateinit var adapterDigimon: AdapterDigimon

    /**
     * Metodos utilizados para el CRUD (crear, editar y elimnar).
     */

    init {
        initData()
    }

    private fun initData() {
        listDigimons = DaoDigimons.mydao.getDataDigimons().toMutableList()
    }

    fun loggOut() {
        Toast.makeText(context, "Datos mostrados por pantalla", Toast.LENGTH_SHORT).show()
        listDigimons.forEach {
            println(it)
        }
    }

    fun setAdapter() {
        val myActivity = context as MainActivity
        adapterDigimon =
            AdapterDigimon(listDigimons, { pos -> delDigimon(pos) }, { pos -> updateDigimon(pos) })
        myActivity.binding.myRecyclerView.adapter = adapterDigimon
    }

    private fun updateDigimon(pos: Int) {
    }

    private fun delDigimon(pos: Int) {
        Toast.makeText(
            context,
            "Ha sido borrado el digimon con la posicion $pos", Toast.LENGTH_SHORT
        ).show()
        listDigimons.removeAt(pos)
        adapterDigimon.notifyItemRemoved(pos)
    }

    /**
     * Metodos utilizados para el Login & Registro.
     */

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