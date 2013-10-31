AutoDropBox
===========

Abstration:
----------
Dropbox is now offering a referral program, in which for each people register and install dropbox through your referral link, your dropbox capacity will increased 500Mbs ( 0.5G ). However, the maximum expansion for the storage is 16G. Taking that advantage, this tool demonstrates how to automate (in other word, scrape) the referral procedure.

In order to have 0.5G, other user has to perform 2 tasks: register through the referral link and install dropbox with the registered account. This github only hosts the first part (Phase 1) of the tool which helps automate the register process through dropbox. Another part of it is to install dropbox and link the current machine to the account will not be shown here, as it's critical. 

![Image](/img/gui.png?raw=true)

Important Notes:
-------------
1. According to Dropbox's ToS, access or search the Services by any means other than our publicly supported interfaces => I'm not responsible for anythin.
2. The purpose of this tool is to demonstrate how to automate a web services, along with analyzing how online services can be exploited => for education purpose only.
3. Copying, re-producing, re-distributing this tool without my agreement is a crime :), this is published under GNU public license.

Languages/Tools:
-----------------
This tool was tested/programmed using:

1. Java 7.45 (Eclipse Kepler)
2. Selenium 2.04
3. Ubuntu 12.04 x64
 

How to use:
----------
GUI has pretty much everything that you need to use.

- Sock Button / Sock Field: initialize connection through socks. (Read Secured Connection below)
- Start Button: start the program.
- Save Button: save list of registered accounts to file.
- Referral Link: link that you want to register through.
- Number of Accounts: How many account you want to register. (I recommend register as less as possible each times, 5 is max)
- Display Area: every information will be updated through this field, i will also display the completed task.

Using socks is mandantory!!! But not required!!!

How's things work:
-----------------
- Selenium WebDriver is the heart of the code, it will create a virtual firefox with custom reference/configuration. (for the purpose of demonstration, it is visible to check)
- The WebDriver will browse through the referral link, parse in the emails and password, then manipulate the mouse click and form submission.
- How emails/First name/Last Name generated: http://forum.codecall.net/topic/49665-java-random-name-generator/

Secured Connection:
-----------------
Imaging you keep connecting to the same website with the same header/user-agents/IP/MacAddress/HardwareID etc ... it will automatically (for some websites) be blocked as it may some kinds of DDoS. However, with the network infrastructure now, it is not even possible (I guess).

There are 3 improvements for secured connection by this tool:

1. User-Agent: it will be generated every time a connection is made.
2. MAC Address Spoofing: which is pretty much not included in this public version.
3. IP Spoofing: I don't use proxy as it is not secured and slow. This tool implements sock5 as it's unique and and fast. There are many websites providing sock5 for free but sometimes it's as slow as proxy. 

Initialization:
--------------
How to initialize the projects:
- All config and structure in pom.xml
- Initialize: mvn clean install
- Link Eclipse config/libs: mvn eclipse:eclipse
- Import directly from Eclipse
- Make a Source Folder

