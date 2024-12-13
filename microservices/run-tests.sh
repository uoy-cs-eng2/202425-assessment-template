#!/bin/bash

set -e

pushd order-management
./gradlew build dockerBuild
popd

pushd product-management
./gradlew build dockerBuild
popd

docker compose down -v
docker compose up --wait
pushd end2end-tests
./gradlew test
docker compose down -v
popd
