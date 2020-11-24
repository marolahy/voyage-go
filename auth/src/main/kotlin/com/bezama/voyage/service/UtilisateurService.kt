package com.bezama.voyage.service

import com.bezama.voyage.domain.Utilisateur
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.provider.OAuth2Authentication

interface UtilisateurService : UserDetailsService {
    fun saveOAuth2Account(oAuth2Authentication: OAuth2Authentication): Utilisateur
}