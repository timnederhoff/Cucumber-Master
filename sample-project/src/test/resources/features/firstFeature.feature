Feature: A sample feature to demonstate something

  Scenario: a search results in a matching page
    Given the wikipedia page is loaded
    When a search with keyword "bunny" is performed
    Then the page with title "Rabbit" is shown

#  Scenario: when the pending exception is at last
#    Given the first test passes
#    Then the third test should fail
#    When the second test is skipped
