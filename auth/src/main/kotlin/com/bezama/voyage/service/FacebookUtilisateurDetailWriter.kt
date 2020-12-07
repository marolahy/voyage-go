package com.bezama.voyage.service

import com.bezama.voyage.domain.Utilisateur

object  FacebookUtilisateurDetailWriter : UtilisateurDetailWriter  {
    override fun createAccount(username: String, details: Map<*, *>): Utilisateur {
        val email: String = details["email"] as String
        val firstName: String = details["first_name"] as String
        val lastName: String = details["last_name"] as String

        return Utilisateur(username = username, email = email, firstName = firstName, lastName = lastName)
    }
}