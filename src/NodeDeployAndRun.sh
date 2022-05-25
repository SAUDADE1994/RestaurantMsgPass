#!/usr/bin/env bash
# Parameters
DIRNAME=$1
DESCRIBE=$2
MAIN=$3
USER=$4
PORT=$5

echo "Killing process running in port $PORT"
sshpass -f password ssh "$USER" "fuser -k $PORT/tcp"
echo "Transferring data to the $DESCRIBE node."
sshpass -f password ssh "$USER" "mkdir -p test/RestaurantMsgPass"
sshpass -f password ssh "$USER" "rm -rf test/RestaurantMsgPass/*"
sshpass -f password scp "$DIRNAME".zip $USER:test/RestaurantMsgPass
echo "Decompressing data sent to the $DESCRIBE node."
sshpass -f password ssh "$USER" "cd test/RestaurantMsgPass ; unzip -uq $DIRNAME.zip"
echo "Executing program at the server $DESCRIBE."
sshpass -f password ssh "$USER" "cd test/RestaurantMsgPass/$DIRNAME ; java -cp genclass.jar: $MAIN"
echo "Server shutdown."
sshpass -f password ssh "$USER" "cd test/RestaurantMsgPass/$DIRNAME ; less stat"
