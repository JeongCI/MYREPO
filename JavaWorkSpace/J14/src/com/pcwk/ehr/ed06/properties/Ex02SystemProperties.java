package com.pcwk.ehr.ed06.properties;

import java.util.Enumeration;
import java.util.Properties;

public class Ex02SystemProperties {

	public static void main(String[] args) {
		Properties sysProp = System.getProperties();
		
		Enumeration enuma = sysProp.propertyNames();
		
		while(enuma.hasMoreElements()) {
			String key = (String) enuma.nextElement();
			System.out.println(key + ", " + sysProp.getProperty(key));
		}
	}

}
//java.runtime.name, Java(TM) SE Runtime Environment
//sun.boot.library.path, C:\Program Files\Java\jdk1.8.0_281\jre\bin
//java.vm.version, 25.281-b09
//java.vm.vendor, Oracle Corporation
//java.vendor.url, http://java.oracle.com/
//path.separator, ;
//java.vm.name, Java HotSpot(TM) 64-Bit Server VM
//file.encoding.pkg, sun.io
//user.script, 
//user.country, KR
//sun.java.launcher, SUN_STANDARD
//sun.os.patch.level, 
//java.vm.specification.name, Java Virtual Machine Specification
//user.dir, C:\DCOM_0725\03_JAVA\WorkSpace2\J14
//java.runtime.version, 1.8.0_281-b09
//java.awt.graphicsenv, sun.awt.Win32GraphicsEnvironment
//java.endorsed.dirs, C:\Program Files\Java\jdk1.8.0_281\jre\lib\endorsed
//os.arch, amd64
//java.io.tmpdir, C:\Users\ITSC\AppData\Local\Temp\
//line.separator, 
//
//java.vm.specification.vendor, Oracle Corporation
//user.variant, 
//os.name, Windows 10
//sun.jnu.encoding, MS949
//java.library.path, C:\Program Files\Java\jdk1.8.0_281\bin;C:\WINDOWS\Sun\Java\bin;C:\WINDOWS\system32;C:\WINDOWS;C:/Program Files/Java/jdk1.8.0_281/bin/../jre/bin/server;C:/Program Files/Java/jdk1.8.0_281/bin/../jre/bin;C:/Program Files/Java/jdk1.8.0_281/bin/../jre/lib/amd64;C:\WINDOWS\system32;C:\WINDOWS;C:\WINDOWS\System32\Wbem;C:\WINDOWS\System32\WindowsPowerShell\v1.0\;C:\WINDOWS\System32\OpenSSH\;C:\Users\ITSC\AppData\Local\Microsoft\WindowsApps;C:\Program Files\Bandizip\;C:\Program Files\Java\jdk1.8.0_281\bin;;C:\App\eclipse;;.
//java.specification.name, Java Platform API Specification
//java.class.version, 52.0
//sun.management.compiler, HotSpot 64-Bit Tiered Compilers
//os.version, 10.0
//user.home, C:\Users\ITSC
//user.timezone, 
//java.awt.printerjob, sun.awt.windows.WPrinterJob
//file.encoding, UTF-8
//java.specification.version, 1.8
//user.name, ITSC
//java.class.path, C:\DCOM_0725\03_JAVA\WorkSpace2\J14\bin;C:\DCOM_0725\03_JAVA\WorkSpace2\J14\lib\jsoup-1.15.3.jar;C:\DCOM_0725\03_JAVA\WorkSpace2\J14\lib\log4j-1.2.17.jar;C:\DCOM_0725\03_JAVA\WorkSpace2\J14\source\jsoup-1.15.3-sources.jar
//java.vm.specification.version, 1.8
//sun.arch.data.model, 64
//java.home, C:\Program Files\Java\jdk1.8.0_281\jre
//sun.java.command, com.pcwk.ehr.ed06.properties.Ex02SystemProperties
//java.specification.vendor, Oracle Corporation
//user.language, ko
//awt.toolkit, sun.awt.windows.WToolkit
//java.vm.info, mixed mode
//java.version, 1.8.0_281
//java.ext.dirs, C:\Program Files\Java\jdk1.8.0_281\jre\lib\ext;C:\WINDOWS\Sun\Java\lib\ext
//sun.boot.class.path, C:\Program Files\Java\jdk1.8.0_281\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\sunrsasign.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_281\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_281\jre\classes
//java.vendor, Oracle Corporation
//file.separator, \
//java.vendor.url.bug, http://bugreport.sun.com/bugreport/
//sun.cpu.endian, little
//sun.io.unicode.encoding, UnicodeLittle
//sun.desktop, windows
//sun.cpu.isalist, amd64