Glassfish Settings
====================

* glassfish version : 4.1.1
* jre: jdk7

### Observation

#### Version of Glassfish

* when run glassfish with Intellij and you have setup JAVA_HOME
with a jdk different that JDK7, glassfish still using
the JAVA_HOME of windows environment variables (Ignore the jdk in the intellij glassfish setup),
so is required modified file 'glassfish/config/asenv.bat' add the line

```
set AS_JAVA="C:\bin\jdk1.7.0_80"
set JAVA_HOME="C:\bin\jdk1.7.0_80"
```

#### Problem : glashfish not detect javax.jws.WebService annotaion

* wrong web.xml produce that glassfish does not detect the webservice annotation. To solve
this problem the file web.xml was removed.