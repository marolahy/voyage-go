package com.bezama.voyage.service

import com.bezama.voyage.domain.Utilisateur

object GooglePlusUtilisateurDetailWriter : UtilisateurDetailWriter {
    override fun createAccount(username: String, details: Map<*, *>): Utilisateur {
        val email: String = details["email"] as String
        val firstName: String = details["given_name"] as String
        val lastName: String = details["family_name"] as String

        return Utilisateur(username = username, email = email, firstName = firstName, lastName = lastName)
    }
}