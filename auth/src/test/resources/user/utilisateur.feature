Feature: Gestion des creations des utilisateurs

  Scenario: Enregistrement des utilisateur
    Given en tant que anonyme
    When je veux creer mon compte en fournissant mes information
    Then mon api retourne le http code 201