Hi Dear,
It would be fine if you follow the steps.
Thanks.
  
## Step 1.

if your OS is linux based (like ubuntu) just run start.sh file on any shell.
The script required 
    1) Maven
    2) Docker
    3) Internet connection 
Read end of the script result. 
The script would populate Docker images and run the containers automatically.

## Step 2.

After successfully deployed the docker containers: 

http://localhost:8088

Click "To Show List of Students"
Then you can see the students list which retrieves from DB in this page,
but your need to login user or admin either.


## Step 3.

Click Load button, 
if you logged in by admin you can see 
the batch process result (Spring batch), 
if you logged in by user, you will be faced
Forbidden to do the batch process. 
Then logout and login by admin to see
the result. (Spring Security)

admin account:
    Username: admin 
    Password: admin
    
user account:
    Username: user 
    Password: user

Every refresh the batch loading (updating) the CSV file.
Thank you!
Source code on github:
https://github.com/Sod-Sherman/SpringBootRestDocker

End of the File.
