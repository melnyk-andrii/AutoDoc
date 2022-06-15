# AutoDoc

Environment setup:
IntelliJ IDEA Community

Android Studio

Java

Maven

Appium

Steps to run app and tests:
1.Download project from GitHub and open it in InteliJ.

2.Start Android Studio( Adroid device should have AutoDoc app installed )

3.Start Appium
    Host: 0.0.0.0
    Port: 4723
   

4.Start Appium Session
    Remote Host: localhost
    Remote Port: 4723
    JSON Representation:
    
    
  
    
{
  "deviceName": "emulator-5554",
  "platformName": "android",
  "appPackage": "de.autodoc.gmbh",
  "appActivity": "de.autodoc.gmbh.ui.activity.SplashActivity",
  "noReset": true
}
    
   

4.Open in terminal project folder */users/user/desktop/AutoDoc*

5.Run Command  mvn clean test site

6.Test reports will be in (AutoDoc/target/site)
