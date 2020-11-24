package com.bezama.voyage.service

import com.bezama.voyage.domain.Utilisateur
import com.bezama.voyage.repository.UtilisateurRepository
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UtilisateurServiceImpl (private val oAuthAccountDetailWriterFactory: OAuthUtilisateurDetailWriterFactory,
                              private val accountRepository: UtilisateurRepository) : UtilisateurService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val account = accountRepository.findByUsername(username)
                ?: throw UsernameNotFoundException("Could not find account with username $username!")


        return with(account) {
            User.withUsername(username)
                    .password(password)
                    .authorities("USER")
                    .build()
        }
    }

    override fun saveOAuth2Account(oAuth2Authentication: OAuth2Authentication): Utilisateur {
        val userAuthentication = oAuth2Authentication.userAuthentication
        val details = userAuthentication.details as Map<*, *>
        val accountWriter = oAuthAccountDetailWriterFactory.getAccountDetailWriter(oAuth2Authentication.oAuth2Request.clientId)
        val username = userAuthentication.principal as String

        return accountRepository.findByUsername(username)
                ?: accountRepository.save(accountWriter.createAccount(username, details))
    }
}