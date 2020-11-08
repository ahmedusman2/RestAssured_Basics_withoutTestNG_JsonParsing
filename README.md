# RestAssured_Basics_withoutTestNG_JsonParsing
RestAssured_Basics_withoutTestNG_JsonParsing
java -jar jenkins.war --httpPort=9091


----------------------------------------------------------
Setting up a simple Jenkins pipe Line
----------------------------------------------------------
Setting up a simple project on Jenkins. 
1. Click "new item" from the Dashboard.
2. Name the Project.
3. Select Free "Style Project"
4. Now Mention the Project location by selecting the "Use Custom WorkSpace". 
	4.1 This could be either mentioning the project root path directly: "C:\Work\Porjectroot Directory path"
	or
	4.2 Place your project source code folder at the root path of your Jenkins installation and metion Directory as "$(JENKINS_HOME)/Mavenjava"
5. Now Mention the Build details:
	5.1 Select Maven version. 
	5.2 Set Maven goals .. this could be "test" or test -PRegression //Regression is the name of the profile mentioned in the  pom.xml
6. Now mention the Post build actions like the put reports:**/testng-results.xml


8. Parameterizing your Jenkins project with property
	8.1 select "This project is parameterized"
	8.2 Select "Select Choice paramater" and enter parameters like "chorme, firefox, IE or safarai"

--------------------------------------------------------
Running for mvn test using system property 

mvn test -Dbrowser=chrome
or use choice parameters
mvn test -Dbrowser='$browser'
--------------------------------------------------------

Git 

-------------------------------

Git is distributed open source version control system

1. Create a git hub account
2. Create a git repo
3. you can create public or private repo
4. Open command prompt at project root path.
5. First you need to tell git "who you are". for that "git config" command is used
	>>git config --global user.name "ahmedusman2"
	>>git config --global user.eamil "l1f03bscs2001@gmail.com"
6. 	>>git init	// this will create  initilization file in your local project folder.
7. There are two termanologies in git when you want to place your files to github. "git commit" and "git staging". before you commit anything to git hub you need to staging them and then "commit"

8. 	>>git add * // adding all files to github
	or	
	>>git add <filename> 
9. 	>>git commit -m "my first commit"
10. Now connect your repo to github
11. 	>>git remote add origin https://github.com/ahmedusman2/RestAssured_Basics_withoutTestNG_JsonParsing.git
12.	>> git push origin master 
------------
Cloning a repo
>>git clone <url from hithub of your repo>

----------------------
Pushing your changes to git hub
----------------------
>>git add *
>>git commit -m "commit comments"
>>git remote add origin https://github.com/ahmedusman2/GitDemo.git // if you ar econnecting first time
>>git push origin master


---------------
How to get latest codes from github
----------------
>>git pull origin master

----------------
git branches 


------------------
creating a branch 
------------------
>> git checkout -b <branch name> // -b is creating a new branch 

------------------------
how to check if what branch are you working on or what branch is selected 
>> git branch
---------------------------
creating your new branch and then push that branch to github

1. first create that branch
>> git checkout -b develop// or name it as develop
2. do some changes and save then in your IDE
3. Now add those changes to staging
>> git add *			
4. before you do final commit you you can also check the status of your branch
>> git status // this will show you the changed files "green= all sync" and "red= not sync", for red you need to add again as they were not added to your staging
5. Now you need to commit your code to staging.. then you can only push to git hub. 
>> git commit -m "comments"
6. Now you can do the push. since your are now pushing to your develop branch and not on master, you need to specify the origin 
>> git push origin develop

--------------------
how to get latest code from github from a specific branch
---------------------
>> git checkout <branchname> 
>> git pull <branch name>


----------------------------------------------------------
How to merge any of your branch to master
----------------------------------------------------------
1. Select that master branch
>> git checkout master
>> git merge <branch name that you ned to merge to master>


---------------------------------------
what are merge conflicts?










