Feature: DietitianModule

  Background: Admin sets Authorization
    Given Admin provides valid authentication details

  @GetAllDietitian
  Scenario: Check if Admin able to retrieve all dietitian with valid Endpoint
    When Admin creates and executes GET all dietitian Request
    Then Admin receives 200 OK Status with dietitian response body

  @PostNewDietitian
  Scenario Outline: Check if Admin able to create a dietitian with valid endpoint and request body with Authorization
    When Admin creates and executes POST Request for the dietitian with "<ValidRequestBody>"
    Then Admin receives 201 Created Status with dietitian response body containing "<UniqueDietitianIds>"

    Examples:
      | ValidRequestBody | UniqueDietitianIds |
      | ValidDietitianWithAllValidFieldsPresentInRequestBody | UniqueDietitianIdOne |
      | ValidDietitianWithMissingOptionalFieldInRequestBody  | UniqueDietitianIdTwo |

  @GetDietitianById
  Scenario: Check if Admin able to retrieve a dietitian with valid dietitian ID
    When Admin creates and executes GET dietitian with valid dietitian Id
    Then Admin receives 200 OK Status with required dietitian response body

  @UpdateDietitianById
  Scenario: Check if admin able to update a dietitian with valid dietitianId and mandatory fields in request body
    When Admin creates PUT Request with valid dietitianId and request body
    Then Admin receives 200 OK Status with updated value in response body with message "OK"

  @DeleteDietitianByDietitianId
  Scenario: Check if Admin able to delete a dietitian with valid dietitianId
    When Admin creates DELETE request with valid dietitianId
    Then Admin receives 200 OK Status with message for dietitian


  @MethodNotAllowed
  Scenario: Check if Admin able to retrieve all dietitian with invalid Method
    Given Admin creates GET all dietitian Request
    When Admin sends HTTPS POST Request with valid endpoint
    Then Admin receives 405 Method Not Allowed

  @MethodNotAllowed
  Scenario: Check if Admin able to create a dietitian with invalid Method
    Given Admin creates POST Request for the dietitian with valid request body
    When Admin sends HTTPS GET Request with valid endpoint
    Then Admin receives 405 Method Not Allowed

  @MethodNotAllowed
  Scenario: Check if Admin able to update a dietitian with invalid Method
    Given Admin creates PUT Request with valid dietitianId and request body
    When Admin sends HTTPS GET Request with valid endpoint
    Then Admin receives 405 Method Not Allowed

  @NoAuth
  Scenario: Check if Admin able to retrieve all dietitian with valid endpoint and without Authorization
    Given Admin creates GET Request for the dietitian and with no auth
    When  Admin sends HTTPS GET Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to create a dietitian with valid endpoint and request body without Authorization
    Given Admin creates POST Request for the dietitian with request body and with no auth
    When Admin sends HTTPS POST dietitian Request with valid request Body and endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if Admin able to retrieve a dietitian by dietitianId without Authorization
    Given Admin creates GET dietitian by dietitianId Request for the dietitian with no auth
    When Admin sends HTTPS GET dietitian by dietitianId Request with valid endpoint
    Then Admin receives 401 Unauthorized

  @NoAuth
  Scenario: Check if admin able to update a dietitian with valid dietitianID and mandatory fields in request body without authorization
    When Admin creates PUT Request with valid dietitianId and valid request body
    Then Admin receives 401 unauthorized

  @NoAuth
  Scenario: Check if Admin able to delete a dietitian by dietitianID without Authorization
    Given Admin creates DELETE by dietitianID Request with no auth
    When Admin creates DELETE Request with valid dietitianID
    Then Admin receives 401 Unauthorized

  @PostNewProgram
  Scenario Outline: Check if Admin able to create a dietitian with invalid request body
    Given Admin creates POST Request for the dietitian with "<invalidData>" in request body
    When Admin sends HTTPS POST Request and invalid dietitian request Body with endpoint
    Then Admin receives 400 Bad Request Status

    Examples:
      | invalidData                               |
      | FirstName                                 |
      | LastName                                  |
      | Email Id                                  |
      | HospitalName                              |
      | HospitalCity                              |
      | ContactNumber                             |
      | Education                                 |
      | HospitalPincode                           |
      | DateOfBirth                               |
      | HospitalStreet                            |

    #for Invalid date of birth its giving 201

  @PostNewProgram
  Scenario Outline: Check if Admin able to create a dietitian with empty "<field>"
    Given Admin creates POST Request for the dietitian with "<field>" in request body
    When Admin sends HTTPS POST Request and invalid dietitian request Body with endpoint
    Then Admin receives 400 Bad Request Status

    Examples:
      | field                                     |
      | FirstName                                 |
      | LastName                                  |
      | Email Id                                  |
      | HospitalName                              |
      | HospitalCity                              |
      | ContactNumber                             |
      | Education                                 |
      | HospitalPincode                           |
      | DateOfBirth                               |
      | HospitalStreet                            |
      | ExistingContactNumber                     |
      | ExistingEmailId                           |
      | MissingMandatoryDetails                   |

     #for existing date of birth its giving 400 (DOB should not be unique)

  @UpdateDietitianById
  Scenario Outline: Check if Admin able to Update a dietitian with invalid request body
    Given Admin creates PUT by dietitianId for the dietitian with "<invalidDataToUpdate>" in request body
    When Admin sends HTTPS PUT Request and invalid dietitian request Body with endpoint
    Then Admin receives 400 Bad Request Status

    Examples:
      | invalidDataToUpdate                       |
      | FirstName                                 |
      | LastName                                  |
      | Email Id                                  |
      | HospitalName                              |
      | HospitalCity                              |
      | ContactNumber                             |
      | Education                                 |
      | HospitalPincode                           |
      | DateOfBirth                               |
      | HospitalStreet                            |
      | MissingMandatoryDetails                   |

  @invalidEndPoint
  Scenario: Check if Admin able to retrieve all dietitian with invalid Endpoint
    Given Admin creates GET Request for the dietitian with valid baseURI
    When Admin sends GET Request to the dietitian along with invalid endpoint
    Then Admin receives 404 not found Status with error message

  @invalidEndPoint
  Scenario: Check if Admin able to create dietitian with invalid Endpoint
    Given Admin creates POST Request for the dietitian with valid baseURI
    When Admin sends POST Request to the dietitian along with invalid endpoint
    Then Admin receives 404 not found Status with error message

  @invalidEndPoint
  Scenario: Check if Admin able to retrieve dietitian by Id with invalid Endpoint
    Given Admin creates GET Request for the dietitian with valid baseURI
    When Admin sends GET Request to the dietitian along with invalid endpoint
    Then Admin receives 404 not found Status with error message

  @invalidEndPoint
  Scenario: Check if Admin able to update dietitian with invalid Endpoint
    Given Admin creates PUT Request for the dietitian with valid baseURI
    When Admin sends PUT Request to the dietitian along with invalid endpoint
    Then Admin receives 404 not found Status with error message

  @invalidEndPoint
  Scenario: Check if Admin able to delete dietitian by Id with invalid Endpoint
    Given Admin creates DELETE Request for the dietitian with valid baseURI
    When Admin sends DELETE Request to the dietitian along with invalid endpoint
    Then Admin receives 404 not found Status with error message

  @invalidPathParameter
  Scenario Outline: Check if Admin able to retrieve a dietitian with valid endpoint,invalid pathParameter dietitianId
    Given Admin creates GET Request for the dietitian endpoint  and  "<invalidPathParameterDietitianID>"
    When Admin sends HTTPS GET by invalid dietitianId Request with endpoint
    Then Admin receives 404 Not Found Status along with message

    Examples:
      | invalidPathParameterDietitianID |
      | zero 							|
      | negativeID 						|
      | overFlowInteger					|

  @invalidPathParameter
  Scenario Outline: Check if Admin able to delete a dietitian with valid endpoint,invalid pathParameter dietitianId
    Given Admin creates DELETE Request for the dietitian endpoint  and  "<invalidPathParameterDietitianID>"
    When Admin sends HTTPS DELETE by invalid dietitianId Request with endpoint
    Then Admin receives 404 Not Found Status along with message

    Examples:
      | invalidPathParameterDietitianID |
      | zero 							|
      | negativeID 						|
      | overFlowInteger					|

  @invalidBaseURI
  Scenario: Check if Admin able to retrieve a all dietitian with invalid baseURI
    Given Admin creates GET Request to retrieve all dietitian with invalid baseURI
    When Admin sends HTTPS GET Request with invalid baseURI
    Then Admin receives 404 Not Found Status code with error message

  @invalidBaseURI
  Scenario: Check if Admin able to create a dietitian with invalid baseURI
    Given Admin creates POST Request to create a dietitian with invalid baseURI
    When Admin sends HTTPS POST Request with invalid baseURI
    Then Admin receives 404 Not Found Status code with error message

  @invalidBaseURI
  Scenario: Check if Admin able to retrieve a dietitian by dietitianID with invalid baseURI
    Given Admin creates GET Request to retrieve a dietitian by dietitianID with invalid baseURI
    When Admin sends HTTPS GET Request with invalid baseURI
    Then Admin receives 404 Not Found Status code with error message

  @invalidBaseURI
  Scenario: Check if Admin able to update a dietitian with invalid baseURI
    Given Admin creates PUT Request to create a dietitian with invalid baseURI
    When Admin sends HTTPS PUT Request with invalid baseURI
    Then Admin receives 404 Not Found Status code with error message

  @invalidBaseURI
  Scenario: Check if Admin able to delete a dietitian by dietitianID with invalid baseURI
    Given Admin creates DELETE Request to retrieve a dietitian by dietitianID with invalid baseURI
    When Admin sends HTTPS DELETE Request with invalid baseURI
    Then Admin receives 404 Not Found Status code with error message