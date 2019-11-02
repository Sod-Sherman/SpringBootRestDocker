echo ""
echo "--------------------------------------------------------"
echo "Welcome to Sod's mini project 01"
echo ""
echo "--------------------------------------------------------"
echo "Now cleaning and compiling java to jar project using by maven"
echo "--------------------------------------------------------"

mvn clean
mvn package

echo ""
echo "--------------------------------------------------------"
echo "Thanks for patient.."
echo "--------------------------------------------------------"

if [ "$(docker ps -aq -f status=exited -f name=sodMiniProject01-app)" ]; then
  # cleanup
  echo "--------------------------------------------------------"
  echo "Now cleaning old container and docker images named by my project ..."
  echo "--------------------------------------------------------"


      docker container rm -f sodMiniProject01-app MyStudentsDB
      docker image rm sod-miniproject01

fi

echo ""
echo "Thanks for patient.."
echo ""
echo "--------------------------------------------------------"
echo "Now building docker image from java jar project using Dockfile information ..."
echo "--------------------------------------------------------"

docker build -t sod-miniproject01 .

echo ""
echo "--------------------------------------------------------"
echo "see docker images: sod-miniproject01:latest and  mariadb:latest"
echo "--------------------------------------------------------"

docker images

echo ""
echo "--------------------------------------------------------"
echo "Now composing 2 containers which are related my spring-boot-app and mysql using docker-compose.yml file."
echo "--------------------------------------------------------"

docker-compose up -d

#read -n 1 -s -r -p "Press any key to start containers"
#docker container start sodMiniProject01-app


echo ""
echo "--------------------------------------------------------"
echo ""
echo "Now open your browser and write:"
echo "URL: http://localhost:8088"
echo "username for Admin: admin password: admin"
echo "username for User: user password: user"
echo "Enjoy it! Thank you!!!"
echo "README.md is more clear understanding for checking functionality."
echo "                        the script written by Sodbileg at MUM.EDU"
echo "--------------------------------------------------------"
echo ""
