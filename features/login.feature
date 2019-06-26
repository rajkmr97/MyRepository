Feature: Login Myntra

Scenario Outline: Login with Valid Credentials
	Given User is on Myntra Home Page
	When User Navigate to Login Page
	And User enters "<username>" and "<password>"
	Then User successfully Logged in
	
	Examples:
	
	|username               |Password  |
	|ramkmrshiv@gmail.com	|9988776655|
	|baladharini@gmail.com  |9941898416|
	
	
	