# petstoreapi
@petstore
Feature: Pet store - add/create pets to store, update, verify and remove a pet record.

  As a store admin
  I want to utilise endpoint of the pet store API's
  So I can add & update and delete my pet store details in the store

 @sanity
  Scenario: Verify as a admin of the store i can add , update  and remove a pet record
    Given create Post request to add a new pet to the store
    When pet was created verify the data
    And they can update the pet information using the PUT request and verify the updated information in response
    Then can delete the pet using DELETE request and verify the pet is deleted successfully
    
    
    To run the prject :
    run command "mvn verify"
