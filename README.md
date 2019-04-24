
[![Build Status](https://travis-ci.org/tatitati/HTTP_AKKA_project.svg?branch=master)](https://travis-ci.org/tatitati/HTTP_AKKA_project)


# Todo:
### with scala
- [ ] Investigate default values in case classes. Behaviour is not as I was expecting

### with code
- [x] ~Add unique keys for domain ids~
- [ ] Simplify builders and isolation of them, unnaply() might help?
- [x] ~Create transformer Code->Auth (this will be a domain service)~
- [ ] Add foreign keys (by the last steps)
- [ ] Add db encryption with sha-256  :fire:
- [ ] Design Register/login of a user :fire:
- [ ] Design Register/login of a third :fire:
- [ ] Start Application layer
- [ ] Investigate how to handle user-session

### with sbt
- [ ] How to tag tests? (and filter them in the CLI)
- [ ] Create custom taks in SBT to run tests in specific app-layers
- [ ] How to set environment variables like Hosts, port for Redis?, for each environment...scala-env

### With general coding concepts:
- [ ] Investigate thread safe (multiple execution contexts)

### with project
- [ ] Add license file




# Purpose

Is a project that try to implement some concepts about oauth.

# Problem statement


# Overview


# Pre-requisites

```
redis-server
brew services start mysql@5.7
```

# Instructions

```
sbt reload update
sbt test
sbt 'testOnly *app.domain*'
sbt 'testOnly *app.persistence*'
sbt run
```

Visit: http://localhost:8080/ping

# Preview


# Credits

# License

The MIT License (MIT). Please see License File for more information.
 



