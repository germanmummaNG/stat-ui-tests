# stat-ui-tests
UI Tests for Stat Dashboard Web Application

# Running tests
mvn clean verify -Dbrowser=chrome

Supported browser property options: chrome, firefox, ie, edge, safari

# Generating reports
mvn allure:serve
