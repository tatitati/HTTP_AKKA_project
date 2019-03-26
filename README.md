
[![Build Status](https://travis-ci.org/tatitati/HTTP_AKKA_project.svg?branch=master)](https://travis-ci.org/tatitati/HTTP_AKKA_project)


# Todo:

- [ ] **Complete persistence of Token firstly to persist later Auth**
- [ ] **Think about Auth, it reference another whole aggregate (third), but it shouldnt**
- [ ] Add license file
- [ ] in infrastructure/user ther is a mapper. Changes in domain ripple to changes into this mapper, in a different layer.
Should we put this domain + infrastructure under the same folder-component "user"?, in this way the changes of one component keeps together at least, and might make mroe obvious that something is wrong when something from this component that is not an ID is needed outside. We can keep a better boundary persistence (AKKA: aggregate)?
- [ ] How to tag tests? (and filter them in the CLI)
- [ ] Create custom taks in SBT to run tests in specific app-layers
- [ ] How to set environment variables like Hosts, port for Redis?, for each environment...scala-env
- [ ] Create database in travis.yml to fix build


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
 



