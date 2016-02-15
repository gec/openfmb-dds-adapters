#/bin/sh

if [ -z "$RTIDDSGEN" ]; then
    echo "Must set RTIDDSGEN"
    exit 1
fi

rm -rf dds-bindings/src/main/java/*
for i in `ls idl/*.idl`; do
    echo "$i"
    $RTIDDSGEN -d dds-bindings/src/main/java/ -language Java -package org.openfmb.model.dds.rti -I idl/ $i
done

