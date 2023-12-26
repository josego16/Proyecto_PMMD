package com.example.proyecto_pmmd.controller

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import com.example.proyecto_pmmd.LoginActivity
import com.example.proyecto_pmmd.MainActivity
import com.example.proyecto_pmmd.adapter.AdapterDigimon
import com.example.proyecto_pmmd.dao.DaoDigimons
import com.example.proyecto_pmmd.databinding.FragmentRecyclerBinding
import com.example.proyecto_pmmd.dialogues.DialogLogin
import com.example.proyecto_pmmd.dialogues.DialogNewDigimon
import com.example.proyecto_pmmd.dialogues.DialogRegister
import com.example.proyecto_pmmd.models.Digimon

class Controller(
    private var context: Context,
    private var binding: FragmentRecyclerBinding) {
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
        adapterDigimon = AdapterDigimon(
            listDigimons,
            { pos ->
                delDigimon(pos)
            },
            { pos ->
                updateDigimon(pos)
            }
        )
        initOnClickListener()
        binding.myRecyclerView.adapter = adapterDigimon
    }

    private fun initOnClickListener() {
        binding.idBtnAdd.setOnClickListener {
            addDigimon()
        }
    }

    private fun addDigimon() {
        Toast.makeText(context, "Añadiremos un nuevo Digimon", Toast.LENGTH_SHORT).show()
        val dialog = DialogNewDigimon { digimon ->
            okOnNewDigimon(digimon)
        }
        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Añadimos un nuevo Digimon")
    }

    private fun updateDigimon(pos: Int) {
        Toast.makeText(context, "Editaremos el Digimon en la posición $pos", Toast.LENGTH_SHORT)
            .show()
        val dialog = DialogNewDigimon { digimon ->
            okOnUpdateDigimon(pos, digimon)
        }
        val myActivity = context as MainActivity
        dialog.show(myActivity.supportFragmentManager, "Editamos el Digimon en la posición $pos")
    }

    private fun okOnUpdateDigimon(pos: Int, digimon: Digimon) {
        listDigimons[pos] = digimon
        adapterDigimon.notifyItemChanged(pos)
    }

    private fun okOnNewDigimon(digimon: Digimon) {
        listDigimons.add(listDigimons.size, digimon)
        adapterDigimon.notifyItemInserted(listDigimons.lastIndex)
    }

    private fun okOnDelDigimon(pos: Int) {
        listDigimons.removeAt(pos)
        adapterDigimon.notifyItemRemoved(pos)
    }

    private fun delDigimon(pos: Int) {
        val dialog = AlertDialog.Builder(context)
            .setTitle("Confirmación")
            .setMessage("¿Estás seguro de que deseas eliminar este Digimon?")
            .setPositiveButton("Eliminar") { _, _ ->
                okOnDelDigimon(pos)
            }
            .setNegativeButton("Cancelar", null)
            .create()

        dialog.show()
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
        val dialogRegister = DialogRegister(this,
            { fullname, email, username, password, confirmPassword ->
                renderizeRegister(fullname, email, username, password)
            }, {
                msCancel(it)
            })
        dialogRegister.show(lA.supportFragmentManager, "Registrarse")
    }

    private fun renderizeRegister(
        fullname: String,
        email: String,
        username: String,
        password: String
    ) {
        val registerAct = context as LoginActivity
        Toast.makeText(
            context,
            "Fullname: $fullname, Email: $email, Username: $username, Password: $password",
            Toast.LENGTH_SHORT
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