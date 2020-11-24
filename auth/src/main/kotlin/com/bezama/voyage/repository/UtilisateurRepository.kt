package com.bezama.voyage.repository

import com.bezama.voyage.domain.Utilisateur
import org.springframework.data.jpa.repository.JpaRepository

interface UtilisateurRepository: JpaRepository<Utilisateur, Long> {
    fun findByUsername(username: String): Utilisateur?
}