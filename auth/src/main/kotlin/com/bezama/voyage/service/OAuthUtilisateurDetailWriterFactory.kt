package com.bezama.voyage.service

import com.bezama.voyage.config.FacebookConfig
import com.bezama.voyage.config.GooglePlusConfig
import org.springframework.stereotype.Component

interface OAuthUtilisateurDetailWriterFactory  {
    fun getAccountDetailWriter(clientId: String): UtilisateurDetailWriter
}

@Component
class OAuthUtilisateurDetailWriterFactoryImpl(private val facebookConfig: FacebookConfig,
                                              private val googlePlusConfig: GooglePlusConfig) : OAuthUtilisateurDetailWriterFactory {

    override fun getAccountDetailWriter(clientId: String) = when (clientId) {
        facebookConfig.client.clientId -> FacebookUtilisateurDetailWriter
        googlePlusConfig.client.clientId -> GooglePlusUtilisateurDetailWriter
        else -> throw UnsupportedOperationException()
    }
}