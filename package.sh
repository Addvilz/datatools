#!/usr/bin/env sh
TARGET="target/datatools-master-SNAPSHOT-jar-with-dependencies.jar"

if [ ! -f ${TARGET} ]; then
    echo "Target file does not exist, run maven package"
fi

rm ./target/datatools 2> /dev/null
cat ./base.sh > ./datatools
cat ${TARGET} >> ./datatools
chmod +x ./datatools

echo "Built datatools in ./datatools"