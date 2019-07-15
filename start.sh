#!/usr/bin/env bash
echo "****************VALIDATING DOCKER AND DOCKER-COMPOSE**************************************"
command -v docker >/dev/null 2>&1 || { echo >&2 "I require docker but it's \\
not installed, for more details, visit https://docs.docker.com/install/.  Aborting."; exit 1; }
command -v docker-compose >/dev/null 2>&1 || { echo >&2 "I require docker-compose but it's \\
not installed, for more details, visit https://docs.docker.com/install/.  Aborting."; exit 1; }
echo "****************BUILDING ARTIFACTS********************************************************"
sh docker-build/build.sh
echo "****************STARTING DOCKER CONTAINERS************************************************"
docker-compose up
echo "****************PROCESS FINISH ***********************************************************"