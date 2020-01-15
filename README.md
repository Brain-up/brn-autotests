# brn-autotests

Repository that contains autotests for Brain-up project.

## In order to run tests:
1. Clone autotests
2. Execute the following command:

`mvn clean test -DsuiteXmlFile={test_suite_name} -Denv={environment_name}`


Full list of **suites** can be found in a directory: `brn-autotests\src\test\resources\suites`

Full list of **environments** can be found in a directory: `brn-autotests\src\test\resources\environments.properties`

**Example:** `mvn clean test -DsuiteXmlFile=ContractTests.xml -Denv=prod`
