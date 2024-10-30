
Here's a sample README section for adding the json-20210307.jar file to your project:

CATALOG
Overview
This project implements a simplified version of Shamir's Secret Sharing algorithm, focusing on decoding polynomial roots and finding the constant term of an unknown polynomial.

Prerequisites

Java Development Kit (JDK) 21 or higher
IntelliJ IDEA or any other Java IDE
A JSON library (json-20210307.jar)
Adding the JSON Library

To successfully run this project, you need to add the json-20210307.jar library to your project. You can download it using the link below:
Download json-20210307.jar
or
[Download json-20210307.jar](https://repo1.maven.org/maven2/org/json/json/20210307/json-20210307.jar)


Steps to Add the JAR to Your Project in IntelliJ IDEA

Download the JAR file:
Click the link above to download the json-20210307.jar file.
Add the JAR file to your project:

Open your project in IntelliJ IDEA.
Right-click on your project in the Project pane.
Select Open Module Settings (or press F4).
In the Project Structure window, select Libraries.
Click on the + icon to add a new library and select Java.
Navigate to the location where you downloaded json-20210307.jar, select it, and click OK.
Ensure the library is added to the appropriate module of your project.
Confirm the JAR is added:

You should see json-20210307.jar listed under your project libraries. Click OK to close the Project Structure window.
Running the Test Cases
To run the test cases provided in the testcases folder, ensure you have created a JSON file for each test case following the required format.

Create a folder named testcases in your project directory.
Add your test case JSON files (e.g., testcase1.json, testcase2.json) into the testcases folder.
Example Command to Run the Code

You can run your main class using the following command in your terminal or directly from your IDE:
bash
java -cp "out/production/CATALOG;path/to/json-20210307.jar" Main
Replace path/to/json-20210307.jar with the actual path to the JAR file in your system.


Conclusion
Follow these steps to set up your project environment, and you should be able to successfully run the implementation of Shamir's Secret Sharing algorithm.
