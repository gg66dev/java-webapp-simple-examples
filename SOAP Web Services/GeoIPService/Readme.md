Description
==============

* use of soap Service base in Java Brains tutorial

* soap service used.

`http://wsgeoip.lavasoft.com/ipservice.asmx`


## Stub Generation

* using command wsimport, this command is include inside of jdk.
* inside folder `src/main/java`

```
wsimport -keep -Xnocompile http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL
```