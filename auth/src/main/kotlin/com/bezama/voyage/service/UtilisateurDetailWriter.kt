package com.bezama.voyage.service

import com.bezama.voyage.domain.Utilisateur

interface UtilisateurDetailWriter {
    fun createAccount(username: String, details: Map<*, *>): Utilisateur
}