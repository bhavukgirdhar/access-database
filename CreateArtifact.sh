mvn deploy:deploy-file -Dfile=${WORKSPACE}/target/access-database-0.0.1-SNAPSHOT.jar -DgroupId=com.bhavuk.database -DartifactId=access-database  -Dversion=0.0.1-SNAPSHOT -Dpackaging=jar  -Durl=file:./local-maven-repository/ -DrepositoryId=maven-repository  -DupdateReleaseInfo=true
cd /
sudo mkdir -p maven-repository
sudo chown -R jenkins:jenkins maven-repository
cp ${WORKSPACE}/local-maven-repository/. -av /maven-repository