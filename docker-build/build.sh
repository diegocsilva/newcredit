#!/usr/bin/env bash
cd back-end/newcredit 
mvn clean install -DskipTests
cd ../newcredit-engine
mvn clean install -DskipTests
cd ../front-end
npm install
ng build --prod"