#!/usr/bin/env zsh

# Exit on error
set -e

on_exit () {
  echo "Error in script!"
}

trap on_exit ERR

echo "Verifying: if this script is executed from its parent directory"
ls RestaurantMsgPass &> /dev/null

rm -rf ASS2_T2G09.7z
cp -rf RestaurantMsgPass/ ASS2_T2G09
rm ASS2_T2G09/InteractionDiagrams/*drawio
rm ASS2_T2G09/**/.gitignore
rm -rf ASS2_T2G09/.{idea,git}
rm ASS2_T2G09/**/*.class
rm -rf ASS2_T2G09/**/dir*
rm ASS2_T2G09/prepareDelivery.sh

echo "Verifying: pdf interaction diagrams are present"
ls ASS2_T2G09/InteractionDiagrams/*.pdf &> /dev/null
echo "Verifying: if genclass.jar is present"
ls ASS2_T2G09/src/genclass.jar &> /dev/null
echo "Verifying: if password file is present"
ls ASS2_T2G09/src/password &> /dev/null

7z a ASS2_T2G09.7z ASS2_T2G09 &> /dev/null
rm -rf ASS2_T2G09

echo "Delivery is ready!"
exit 0