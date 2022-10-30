## Command to start Hub
java -jar selenium-server-4.5.2.jar hub

## Command to start Node
This node will register:

* Chrome
* Firefox
* Safari

Note: IF you are on Windows OS, please remove part related to safari and add for Edge

java -jar -Dwebdriver.<type>.<name>s path/to/selenium/server.jar node --config /path/to/nodeConfig.json 
java -jar -Dwebdriver.gecko.driver=geckodriver.exe -Dwebdriver.chrome.driver=chromedriver.exe selenium-server-4.5.2.jar node --config node_config.json

NOTE: on Windows need to specify extension like gecko.exe, chrome.exe
## Next

## setup mvn
mvn clean install -DskipTests=true
java -Dbrowser=chrome -jar target\Selenium_K8_Web-1.0-SNAPSHOT-fat-tests.jar

## jenkin
java -jar jenkins.war
Jenkins initial setup is required. An admin user has been created and a password generated.
Please use the following password to proceed to installation:

fbeea8dcdfef44f4a1b3d4516af6d7f1

This may also be found at: C:\Users\Vy Vy\.jenkins\secrets\initialAdminPassword


In second stage, we will learn about how to set up using Docker