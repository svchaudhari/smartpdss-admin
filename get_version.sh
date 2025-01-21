#!/bin/sh

if [ -z "$1" ]; then
    FOLDER=.
else
    FOLDER=$1/
fi

if [ -f "${FOLDER}pom.xml" ]; then
    # Extract the version using grep and sed
    grep -oPm1 "(?<=<version>)[^<]+" "${FOLDER}pom.xml" | cut -d'-' -f1
elif [ -f "${FOLDER}package.json" ]; then
    # Extract the version using grep and sed
    grep -oPm1 '(?<=\b"version": ")[^"]+' "${FOLDER}package.json"
elif [ -f "${FOLDER}VERSION" ]; then
    # Simply output the content of the VERSION file
    cat "${FOLDER}VERSION"
else
    echo "NA"
fi
