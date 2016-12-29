Feature: Gestion Des rôles

En tant que Application je peux voir les privileges d'un utilisateur sans equipe
j'appelle une url de WebService de type "/privilege/ID_USER", et j'obtiens la liste des privilèges de cet utilisateur. 

  Background: 
    Given un utilisateur sans rôles
      And sans équipe
  
  Scenario: Aucun privilèges
     When j'accède au privilège de l'utilisateur
     Then l'utilisateur n'a aucun privilège
  
  Scenario: Role dénué de privilèges attribué à l'utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | null      | 
      And j'attribue la liste de rôle a l'utilisateur
     When j'accède au privilège de l'utilisateur
     Then l'utilisateur n'a aucun privilège
  
  Scenario: Un rôle avec un privilège pour l'utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      And j'attribue la liste de rôle a l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
  
  Scenario: Un rôle avec un privilège pour l'utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      And j'attribue la liste de rôle à l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
  
  Scenario: 2 rôles mono privilège distints assignés à un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | B    | P3        | 
      And j'attribue la liste de rôle à l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P3        | 
  
  Scenario: 2 rôles avec des privilèges distints assignés à un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | B    | P5        | 
      And j'attribue la liste de rôle à l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P3        | 
      | P4        | 
      | P5        | 
  
  Scenario: 2 rôles avec des privilèges assignés à un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P2        | 
      | B    | P2        | 
      | B    | P3        | 
      And j'attribue la liste de rôle à l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P3        | 
  
  Scenario: 1 rôle dénué de privilèges et un rôle avec des privilèges assignés à un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | null      | 
  
      And j'attribue la liste de rôle a l'utilisateur
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
  
  
