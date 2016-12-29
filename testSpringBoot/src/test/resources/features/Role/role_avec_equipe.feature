Feature:Gestion des rôles sans équipes 

En tant que Application je peux voir les privileges d'un utilisateur qui est dans une equipe

j'appelle une url de WebService de type "/privilege/ID_USER", et j'obtiens la liste des privilèges de cet utilisateur. 

  Background: 
    Given une entité
      And une sous entité appartenant à l'entité
      And une équipe appartenant à la sous entité
      And un utilisateur sans rôles
      And l'utilisateur qui appartient à l'équipe
  
  Scenario Outline: 1 role attribué à une entité ou sous entité ou equipe un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      And j'attribue la liste de rôle a <Object>
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
  
  Examples: 
      | Object      | 
      | user        | 
      | equipe      | 
      | sous entité | 
      | entité      | 
  
  Scenario: 1 role attribué à une entité ou sous entité ou equipe ou un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | user        | A    | 
      | equipe      | B    | 
      | sous entité | C    | 
      | entité      | D    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P3        | 
      | P4        | 
      | P5        | 
      | P6        | 
      | P7        | 
  
  Scenario: 1 role attribué à une entité ou sous entité ou un utilisateur
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | user        | A    | 
      | sous entité | C    | 
      | entité      | D    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P5        | 
      | P6        | 
      | P7        | 
  
  Scenario: 1 role attribué à une entité ou sous entité ou equipe 
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | equipe      | A    | 
      | sous entité | C    | 
      | entité      | D    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P5        | 
      | P6        | 
      | P7        | 
  
  Scenario: 1 role attribué à une entité ou utilisateur ou equipe 
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | equipe      | A    | 
      | utilisateur | C    | 
      | entité      | D    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P5        | 
      | P6        | 
      | P7        | 
  
  Scenario: 1 role attribué à une sous entité ou utilisateur ou equipe 
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | equipe      | A    | 
      | utilisateur | C    | 
      | sous entité | D    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P5        | 
      | P6        | 
      | P7        | 
  
  Scenario: Doublon de privilèges sur des rôles différents attribués à des niveau différents
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P2        | 
      | B    | P3        | 
  
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | equipe      | A    | 
      | utilisateur | B    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P3        | 
  
  Scenario: Plusieurs rôles attribués à plusieurs niveau
    Given une liste de role 
      | Role | Privilège | 
      | A    | P1        | 
      | A    | P2        | 
      | B    | P3        | 
      | B    | P4        | 
      | C    | P5        | 
      | D    | P6        | 
      | D    | P7        | 
      | E    | P8        | 
      | E    | P9        | 
      | F    | P10       | 
      | F    | P11       | 
      | G    | P11       | 
      | G    | P12       | 
      | H    | P13       | 
      And j'attribue la liste de rôle est distribué : 
      | Object      | Role | 
      | entité      | A    | 
      | entité      | B    | 
      | sous entité | C    | 
      | sous entité | D    | 
      | équipe      | E    | 
      | équipe      | F    | 
      | équipe      | G    | 
      | utilisateur | H    | 
  
     When j'accède au privilège de l'utilisateur	
     Then l'utilisateur a la liste de privilèges suivante : 
      | privilège | 
      | P1        | 
      | P2        | 
      | P3        | 
      | P4        | 
      | P5        | 
      | P6        | 
      | P7        | 
      | P8        | 
      | P9        | 
      | P10       | 
      | P11       | 
      | P12       | 
      | P13       | 
  
