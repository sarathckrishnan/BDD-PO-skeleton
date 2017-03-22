#How to run the test from commandline
mvn clean test -Dcucumber.options="--tags @<tag-name>" -Denvironment=<environment> -Dbrowser=<browser>

Example : mvn clean test -Dcucumber.options="--tags @login-test" -Denvironment=ci -Dbrowser=firefox
