# Batch Bot

Live site: [seandefontaine.com](https://seandefontaine.com)

<!--
## 🚨 Forking this repo (please read!)

Many people have contacted me asking me if they can use this code for their own website, and the answer to that question is usually **yes, with attribution**.

I value keeping my site open source, but as you all know, _**plagiarism is bad**_. It's always disheartening whenever I find that someone has copied my site without giving me credit. I spent a non-trivial amount of effort building and designing this iteration of my website, and I am proud of it! All I ask of you all is to not claim this effort as your own.

Please also note that I did not build this site with the intention of it being a starter theme, so if you have questions about implementation, please refer to the [Gatsby docs](https://www.gatsbyjs.org/docs/).

### TL;DR

Yes, you can fork this repo. Please give me proper credit by linking back to [brittanychiang.com](https://brittanychiang.com). Thanks!
-->

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