Feature: Search
    The search functionality will allow search terms to be entered and recognised results available for selection

    Scenario: Entering a search term matching the name of a single food item, the single food item will be available for selection
        Given I navigate to the homepage
        When I enter search term 'Pips Crunchy Peanut Butter'
        Then the following food item should be available for selection
            | Name                       |
            | Pips Crunchy Peanut Butter |

    Scenario: Entering a search term matching the name of multiple food items, multiple food items will be available for selection
        Given I navigate to the homepage
        When I enter search term 'Peanut'
        Then the following food item should be available for selection
            | Name                       |
            | Pips Crunchy Peanut Butter |
            | Peanuts 250g               |

    Scenario Outline: Entering a search term that doesn't match the name of a food item, no food items will be available for selection
        Given I navigate to the homepage
        When I enter search term <Search Term>
        Then the following food item should be available for selection
            | Name                              |
            | The search term is not recognised |

        Examples:
            | Dataset Name     | Search Term    |
            | Unrecognised     | 'kettle'       |
            | Blank            | ' '            |
            | Non-alphanumeric | '!"£$%^&*()_+' |
