Feature: Adding a users

blablabla spécification sur une user story
 
Scenario: Adding a user make him present in database
Given users are presents in database
 When i add customers : 
|firstName | lastName|
|     jean |   roger |
|    roger |     jean|
 Then user list contains new entry :  
|firstName | lastName|
|     jean |   roger |
|    roger |     jean|