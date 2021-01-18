Feature: conection
Scenario: Connexion avec un mot de passe incorrect
Given users
| nom    | prenom    | email               | motDePasse |
| Dupont | Jean      | jdupont@test.com    | azerty123  |
When i try to connect mySelf
| email            | motDePasse |
| jdupont@test.com | toto26     |
Then this message is displyed"Le nom utilisateur ou le mot de passe est incorrect"