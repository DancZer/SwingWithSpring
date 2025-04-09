REM start db for tests
docker run -d -e POSTGRES_DB=employees -e POSTGRES_USER=employees -e POSTGRES_PASSWORD=employees -p 5432:5432 --name employees-postgres-build postgres

REM build backend
cd employees-backend
call gradlew.bat build

REM stop DB
docker stop employees-postgres-build


cd ..

docker-compose up --build -d


start "" java -jar employees-backend//build//libs//employees-rest-0.0.1-SNAPSHOT.jar -swing