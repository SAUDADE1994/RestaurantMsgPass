#!/usr/bin/env bash
source ./buildAndGenerateGlobal.sh
echo "Deploying and decompressing execution environments."
mkdir -p "$HOME"/test/RestaurantMsgPass
rm -rf "$HOME"/test/RestaurantMsgPass/*
PROJ="$HOME"/test/RestaurantMsgPass
cp dirGeneralRepos.zip "$PROJ"
cp dirKitchen.zip "$PROJ"
cp dirBar.zip "$PROJ"
cp dirTable.zip "$PROJ"
cp dirStudents.zip "$PROJ"
cp dirWaiter.zip "$PROJ"
cp dirChef.zip "$PROJ"
cd "$PROJ" || (echo "cd failed" && exit)
#unzip -q "{dirGeneralRepos,dirKitchen,dirBar,dirTable,dirStudents,dirWaiter,dirChef}.zip"
unzip -q "*.zip" && echo "Expected: 7"
