## Test automation project using Cucumber and Java

---

## Tested Website
[Demoblaze](https://www.demoblaze.com/)

## Pre-requisites (Installations):
- JDK 17.0.1+
- Maven
- IntelliJ IDE
- Check your Chrome version and download the right version of chromedriver from <br/>
   https://chromedriver.chromium.org/downloads <br/>
  Then replace the chromedriver from src>test>resources with the downloaded one.

## Dependencies:
- cucumber-java 7.8.1
- cucumber-testng 7.8.1
- cucumber-junit 7.8.1
- selenium-java 4.5.0
- cucumber-compiler-plugin 3.10.1
- maven-surefire-plugin 3.0.0.M6
<br/>

## Path Setup
- Set JDK bin path to the environment variables
- Set Maven bin path to the environment variables

## Running the Tests:
- Open project in IntelliJ IDE.
- Open the terminal (from IntelliJ IDE) and execute the command 
    ```mvn clean install``` <br/><br/>
- For running single Scenario- 
  - open a Feature file from directory: 
     src>test>java>features
  - then right click and select run scenario
- For suite-run:
  - open TestNG.xml file from project root directory
  - then right click and select run
- For running from terminal:
  - execute command ```mvn test```
<br/>
