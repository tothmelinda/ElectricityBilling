#Electricity Billing Platform

#About

This project is about electricity billing service, which calculates the units consumed during a specified time and the 
money to be paid for those units.

##Run Locally

In order to run locally, the following points should be accomplished:
- [Prerequisites](#prerequisites)
- [Java](#java17)
- [Maven](#maven)
- [Intellij](#intellij)
- [GIT](#git)
- [DB Setup](#db-setup)

###DB Setup

First, ensure that docker is properly installed. 

Then, pull and start an MSSQL docker image: 
```bash 
sudo docker run -d -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=<YourStrong@Passw0rd>" -p 1433:1433 --name sqlserver_local -h 
sqlserver_local mcr.microsoft.com/mssql/server:2022-latest  
```
!!! Note: remember SA_PASSWORD set during this step, as it will be used in later stages. 

Next, access it via shell and create a new database, login and user:
```bash 
# Enter docker image in bash mode: 
sudo docker exec -it sqlserver_local "bash"
 
 # Access the SQL Server with the known user and password (see the pull and start docker image step) 
 /opt/mssql-tools/bin/sqlcmd -S localhost -U SA -P "<YourStrong@Passw0rd>"       
  
 # Once SQL Server is accessed (the terminal lines will now start with number> (ex: 1>))
  Create database electricity 
  go 
  Use electricity
  go 
  create login electricity_login with password = "not@dm1n" 
  go 
  create User electricity_user for login electricity_login 
  go 
  alter role db_owner add member electricity_user 
  go 
  exec sp_addrolemember 'db_owner', 'electricity_user' 
  go  
  
  Once these steps are done, hit CTRL+C to exit SQL Server, then CTRL+D to exit bash mode for the docker image. 
```