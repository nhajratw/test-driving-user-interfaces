Feature: CodeMash Bacon Tracker

Scenario: The header should appear correctly

    Given I am on the homepage
    Then I should see the header "CodeMash Bacon Tracker"
    	And the logo should appear
    
Scenario: A new person can be added

	Given I am on the homepage
	When I add "Codemash Man" with an email of "cm@codemash.org"
	Then a confirmation should appear for "Codemash Man"
    
Scenario: Existing people should show up in a list

	Given I am on the homepage
	When I add "Joe" with an email of "joe@joe.com"
	Then the person "Joe" should show up in the list