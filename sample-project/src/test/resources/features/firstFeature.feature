Feature: A sample feature to demonstate something

  Scenario: a scenario that should not fail
    Given the first test passes
    When the second test is skipped
    Then the third test should fail

  Scenario: when the pending exception is at last
    Given the first test passes
    Then the third test should fail
    When the second test is skipped
