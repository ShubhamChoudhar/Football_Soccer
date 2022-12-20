Readme file

This project is about creating tables and load the records in tables of 2014 world cup soccer tournanment.

Execution of project
Step 1 - Connect your computer to Pulse VPN if you are off campus.
Step 2 - Connect your computer to omega server. You will need SSH(Secure Shell) to connect to server. You have to run the 
commmand in command prompt - "ssh <net-id>@omega.uta.edu"
Step 3 - After connecting to omega server, write sqlplus in command prompt. You will connected to oracle database. Write 
your username and password.
Step 4 - Run the create table sql file. To run, write start filename in command prompt. After successfully executing sql 
file tables will be created in database.
Step 5 - Include oracle jdbc and csv reader jar file.
Step 6 - Do oracle jdbc connection. After connecting run java file.
Step 7 - After successfully executing the java file, all the records will be loaded to the tables.

Creating Spool File
After executing the above steps successfully
Step 1 - Write spool filename in command prompt.
Step 2 - Write sql query in command prompt eg. SELECT * FROM COUNTRY
Step 3 - The output will be stored in spool file. eg. All the records/ data of table COUNTRY will be stored in the spool
file.
Step 4 - spool off