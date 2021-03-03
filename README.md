# QA-Test-Automation-Framework

Test Automation is the best way to increase the effectiveness, test coverage, and execution speed in software testing.
Automated software testing is important due to the following reasons:
Manual Testing of all workflows, all fields, all negative scenarios is time and money consuming.

For this purpose this project provides the `automation script` written in the `Cucumber - BDD` way.

## Technology Stack
![Selenide Logo](https://selenide.org/images/selenide-logo-big.png)
![Cucumber Logo](https://github.com/cucumber-ltd/brand/raw/master/images/png/notm/cucumber-black/cucumber-black-128.png)

## 🚀 Getting started

In order to run the provided application, please make sure you have `docker` and `docker-compose` installed on your system.

### 📟 Building and Running the automation scripts

Execute the following commands inside the `project root` folder.

`Build` the docker image:

```bash
docker-compose -f docker-compose.yml build
```

`Run`

```bash
docker-compose -f docker-compose.yml up
```
### 📟 Running the automation scripts locally

In order to install and execute automation scripts locally,
you will need `mvn` installed on your machine

Execute following commands inside `project root` directory

`Install`

```bash
mvn clean install
```

`Run`

```bash
mvn test -Dbrowser=chrome -Dheadless=true -Denv=qa
```

## 🔧 Additional tools

- ### IntelliJ / Eclipse
- ### jdk8
- ### maven
