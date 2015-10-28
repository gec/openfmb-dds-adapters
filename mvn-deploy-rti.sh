#!/bin/bash

if [ -z "$JARPATH" ]; then
    echo "Must set JARPATH to location of RTI DDS jar files"
    exit 1
fi

mvn install:install-file -DgroupId=com.rti.ndds \
  -DartifactId=nddsjavad \
  -Dversion=5.2.0 \
  -Dpackaging=jar \
  -Dfile=$JARPATH/nddsjavad.jar
