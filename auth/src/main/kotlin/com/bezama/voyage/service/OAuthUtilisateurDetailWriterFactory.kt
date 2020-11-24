package com.bezama.voyage.service

interface OAuthUtilisateurDetailWriterFactory  {
    fun getAccountDetailWriter(clientId: String): UtilisateurDetailWriter
}
