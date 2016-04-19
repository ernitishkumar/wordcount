# wordcount
A Jersey based REST Http Utility to search for a given word inside a file. Created using Maven.

Welcome to HTTP based word count utility. This project gives you an utility where you can find out the occurence of a particular
word inside a text file.

Please follow the below steps to get the project started.

1. Create a folder name wordcount.
2. Initialize the folder with git init
3. Add a git remote for this project as git remote add "remotename" https://github.com/ernitishkumar/wordcount.git
4. Make a pull request using this remote. The project will get cloned at your end.
5. Now navigate to src\main\java\com\nitish\freecharge\utility folder from your current folder.
6. Open GlobalResources.java file change the value of FILE_PATH with the text file containing valid english words to be searched for words.
7. navigate back to wordcount folder
8. Run following command "mvn compile"
9. Then run "mvn clean package" . This command will package the project into a jar file with name nitishsAwesomeProject.jar
   in target forlder of the current directory.

<h2> Running the Project <h2>

There are two ways to run our app. 

1. Through jetty server deployment.
2. Through jar file.

<h3>1. Steps for running the app through jetty server deployment </h3>
1. Navigate to wordcount folder
2. execute following maven command "mvn jetty:run"
   This command will start the jetty server of our app and deploy our jersey based webapp onto it.
3. Now open any browser on same machine and access the following url : http://localhost:9999/wordcount/

4. Home page will open with an input box for the word to be search and click get count button. 
5. On next page you will get the count of the provided word in json format.
6. Subsequently you can change query="with any random word" and hit enter to get the count.

<h3>2. Steps for running the app through jar</h3>
1. Navigate to wordcount folder
2. run the following command java -jar target\nitishsAwesomeProject.jar
3. This command will start the embedded jetty server on 9999 port number.
4. Now open any browser on same machine and access the following url : http://localhost:9999/wordcount/count?query="word to be searched"
5. This request will return the count of the word in json format.





