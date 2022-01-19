# Batch Bot

A Spring Batch Java project that parses CSV data and loads the DBO in a HyperSQL database.

## 🛠 Installation & Set Up

***NOTE THIS PROJECT WAS BUILT USING A WINDOWS 10 MACHINE***

1. Download Maven binaries from [here](https://maven.apache.org/download.cgi)

2. Download OpenJDK binaries from [here](https://jdk.java.net/java-se-ri/17)

3. Extract these folders to your home directory for similicity (~/ for linux and C:/<user> for windows)

4. Add the full path to your system environment variables (e.g. %MAVEN_HOME% and %JAVA_HOME%)

5. Add the /bin of both folders to the PATH environment variable (e.g. %MAVEN_HOME\bin and %JAVA_HOME%\bin)

## 🚀 Building and Running the Application

1. Build and Package the project

  ```sh
  mvn clean package
  ```

2. Run the Application

  ```sh
  java -jar target/batch-bot-0.0.1-SNAPSHOT.jar
  ```

   or 

  ```shell
  mvn spring-boot:run
  ```