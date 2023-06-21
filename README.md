# Web Automation Framework
A web automation framework created for UI automation in Test Driven Development Style (TDD) approach. It is developed using Java as a programming language. It uses data driven approach for execution of test cases. Data can be sourced from either a database or an excel sheet.

In order to use and run the framework, 
- Download all the files and folders in a parent folder. 
- Open this folder as a 'project' in Eclipse IDE.
- Open the file, 'StartUp.java' in src/test/java/run package.
- Right click anywhere on the window > Run as > Java Application.
  OR, Right Click on POM.xml > Run As > 3 Maven Build... > In Goals textbox, enter 'clean install' > Click on Run.

Following tool stack has been used for development of the framework.
- Language: Java
- Test Engine: TestNG
- Build Tool: Maven
- Test Data: MS Excel (Handling with database has also been implemented)
- Reporting: Custom HTML reports (Allure Report).
- Logging: Apache POI library
- Browser Support: Chrome

The framework can be integrated with jenkins for CI/CD purpose.
