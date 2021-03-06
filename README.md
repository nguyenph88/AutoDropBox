AutoDropBox
===========

Abstration:
----------
Dropbox is now offering a referral program, in which for each people register and install dropbox through your referral link, your dropbox capacity will be increased 500Mbs ( 0.5G ) for each person you bring to dropbox. However, the maximum expansion for the storage is 16G. Taking that advantage, this tool demonstrates how to automate (in other word, scrape or bot, or whatever, you name it) the referral procedure.

In order to have 0.5G, the referral user has to perform 2 tasks: register through the referral link and install dropbox with the registered account. This github only hosts the first part (Phase 1) of the tool which helps automate the register process through dropbox. Another part of it is to install dropbox and link the current machine to the account will not be shown here, as it's critical. 

![Image](/img/gui.png?raw=true)

Important Notes:
-------------
1. According to Dropbox's ToS, access or search the Services by any means other than our publicly supported interfaces => I'm not responsible for anything, use this tool at your own risk.
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
- Display Area: every information will be updated through this field, it will also display the completed task.

Using socks is mandantory!!! But not required!!!

How things work:
-----------------
- Selenium WebDriver is the heart of the code, it will create a virtual firefox with custom reference/configuration. (for the purpose of demonstration, it is visible to check)
- The WebDriver will browse through the referral link, parse in the emails and password, then manipulate the mouse click and form submission.
- How emails/First name/Last Name generated: http://forum.codecall.net/topic/49665-java-random-name-generator/
- How is sock initialized: read my code.

Secured Connection:
-----------------
Imaging you keep connecting to the same website with the same header/user-agents/IP/MacAddress/HardwareID etc ... it will automatically (for some websites) be blocked as it might be some kinds of DDoS. However, with the network infrastructure nowadays, it is not even possible (I guess).

There are 3 improvements for secured connection by this tool:

1. User-Agent: it will be generated every time a connection is made.
2. MAC Address Spoofing: which is pretty much not included in this public version.
3. IP Spoofing: I don't use proxy as it is not secured and slow. This tool implements sock5 as it's unique and and fast. There are many websites providing sock5 for free but sometimes it's as slow as proxy. 

What is Phase 2:
---------------
As I mentioned it's critical, and is extremely restricted to scrape the install process. But sharing some hints won't hurt anyway:

1. I'm kidding, study it by yourselves :) I'm not sharing.
2. Considering using some text command OS, i'm taking adavantages of EC2 and other cloud services, like Azure etc ...
3. This part may not be done by java, but other automatic script like using bash, or python on linux infrastructure ...
4. Things to take into consideration: The referral system doesn't work if you logout and login with another account. You cannot just unistalled dropbox, install a new client and login with the new account. Cookies (not the cookies that you eat) play an important role in the process.

![Image](/img/linux1.png?raw=true)

![Image](/img/linux2.png?raw=true)

Conclusion:
----------
With less effort (may be none) I could be able to get more spaces from Dropbox by using this auto tool. Probably you could be able to speed up (like couple accounts within a min). Mine took long between accounts because I was testing each possbile case that could happen.

In conclusion, the purpose of referring program is to get more people using their service, which I think is awesome. It's not only a cloud storage but also sharing tool between devices. Support them and stop botting T_T ...

![Image](/img/dropbox.png?raw=true)

Dropbox Security Hole:
---------------------
- You may notice that there is no way (or may be hard) to cheat a program (and its security check) in Windows enviroment. That's why Linux or other openOS come in handy.
- You may think this section doesn't have anything to do with the tool, but it does. Why? Because I used them to implement my tool.

### host_id :
- Dropbox links your account and a device by using host_id, it is generated randomly but when it's linked to an account it's unique. Catch that link, and manipulate that. It's an interesting thing to do.
- Let's try purging the dropbox folder: after every time I try sync it with an account, based on a trace, it looks like dropbox uses /dev/urandom as a seed for the data.
- The program procedures also read 16 bytes from this. When the values do not end up in the host id the size corresponds to the size of an md5 checksum, so at a wild guess this is how it is done. 
- I don't believe the value is deterministic. The string of host_id is generated randomly.
- But I believe it is saved in %APPDATA%\Dropbox\config.db 

> What if a trojan try to access and steal the config.db, well that means when I replace my config.db content with your config.db I may get a chance to access your file. Interesting, huh? 
> Up to the time I was doing this testing, dropbox didn't link the config.db to any particular device. Meant that there is no difference between my PC and your PC or my iOS device and your Android device.


A video demonstration helps understand the situation better: http://www.youtube.com/watch?v=SsXV1OXW3fo

### config.db :

Let's analyze the config.db a bit and see what is inside the file (using sqlite3):

- email: (I believe) this is the account's email address. I don't think it does matter at all as I have tried to change the value and the dropbox synchronization process still works.
- dropbox_path: the folder that is (or symlink) to a dropbox folder.
- host_id: this is initialized after I link my device to the dropbox account. Pretty much it doesn't change. (What happen if I change it?) keep in mind that in order to automatize the install process, you have to take advantage of this host_id.


> Since host_id is the only parameter to help sync your device and dropbox account. if you try to change your password after losing your config.db file, it doesn't really affect the exploiter. Unless you unlink everything, resynchronize all the devices and it should help. (i'm not sure, I haven't tried it yet)


### dropbox.db :
- There is nothing much to exploit in this db file, but can you use sqlite to browse its content.
- Take note that the host_id may have something to do with / from this file.
- A nice snippet to demonstrate:


    ```#!/usr/bin/python
 	  import base64, pickle, sqlite3, os, string
 
 	  dropbox_db_path = os.path.expanduser('~/.dropbox/dropbox.db')
 
 	  db = sqlite3.connect(dropbox_db_path)
   	cur = db.cursor()
 	  cur.execute('select key, value from config where key ="host_id" order by key')
 	  for row in cur:
 	        print 'https://www.dropbox.com/cli_link?host_id=' + string.lstrip(pickle.loads(base64.b64decode(row[1]))) if row[1] != None else row[1]
 	  db.close()

I read on the newest article that dropbox has implemented an ecryption way to protect the credential of the PC but I didn't test it yet. I just leave it up to you. In the limitation of this Readme file, i'm just using the most relevant information in order to ultilize and bot the services.


Initialization:
--------------
I don't intend to let script kiddies to use the code, so yeah, a little bit of configuration will help make the program run. Otherwise, it is just a nonsense piece of code.

How to initialize the projects:
- All config and structure in pom.xml
- Initialize: mvn clean install
- Link Eclipse config/libs: mvn eclipse:eclipse
- Import directly from Eclipse
- Make a Source Folder
