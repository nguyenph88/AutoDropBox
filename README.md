AutoDropBox
===========

Abstration:
----------
Dropbox is now offering a referral program, in which for each people register and install dropbox through your referral link, your dropbox capacity will increased 500Mbs ( 0.5G ). However, the maximum expansion for the storage is 16G. Taking that advantage, this tool demonstrates how to automate (in other word, scrape) the referral procedure.

In order to have 0.5G, other user has to perform 2 tasks: register through the referral link and install dropbox with the registered account. This github only hosts the first part of the tool which helps automate the register process through dropbox. Another part of it is to install dropbox and link the current machine to the account will not be shown here, as it's critical. 

Important Notes:
-------------
1. According to Dropbox's ToS, access or search the Services by any means other than our publicly supported interfaces => I'm not responsible for anythin.
2. The purpose of this tool is to demonstrate how to automate a web services, along with analyzing how online services can be exploited => for education purpose only.
3. Copying, re-producing, re-distributing this tool without my agreement is a crime :)

Languages/Tools:
-----------------
This tool was tested/programmed using:
1. Java 7.45 (Eclipse Kepler)
2. Selenium 2.04
3. Ubuntu 12.04 x64
 

Initialization:
--------------
How to initialize the projects:
- All config and structure in pom.xml
- Initialize: mvn clean install
- Link Eclipse config/libs: mvn eclipse:eclipse
- Import directly from Eclipse
- Make a Source Folder

