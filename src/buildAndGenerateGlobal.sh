#!/usr/bin/env bash
echo "Compiling source code."
javac -cp genclass.jar ./**/*.java
echo "Distributing intermediate code to the different execution environments."
echo "  General Repository of Information"
rm -rf dirGeneralRepos
mkdir -p dirGeneralRepos/serverSide/{main,entities,sharedRegions} dirGeneralRepos/commInfra dirGeneralRepos/clientSide/entities
cp serverSide/main/{SimulPar,GeneralReposMain}.class dirGeneralRepos/serverSide/main
cp serverSide/entities/{ServiceProviderAgent,Chef,Student,Waiter}.class dirGeneralRepos/serverSide/entities
cp serverSide/sharedRegions/{GeneralRepos,SharedRegionInterface,GeneralReposInterface}.class dirGeneralRepos/serverSide/sharedRegions
cp commInfra/{Message,ServerCom}.class dirGeneralRepos/commInfra
cp genclass.jar dirGeneralRepos/
echo "  Table"
rm -rf dirTable
mkdir -p dirTable/serverSide/{main,entities,sharedRegions,stubs} dirTable/commInfra
cp serverSide/main/{TableMain,SimulPar,FunctionsIds}.class dirTable/serverSide/main
cp serverSide/entities/{ServiceProviderAgent,Student,Chef,Waiter}.class dirTable/serverSide/entities
cp serverSide/sharedRegions/{Table,TableInterface,SharedRegionInterface,ITable_Student,ITable_Waiter}.class dirTable/serverSide/sharedRegions
cp serverSide/stubs/GeneralReposStub.class dirTable/serverSide/stubs
cp commInfra/{CommunicationChannel,ServerCom,MemException,MemFIFO,MemObject,Message}.class dirTable/commInfra
cp genclass.jar dirTable/
echo "  Bar"
rm -rf dirBar
mkdir -p dirBar/serverSide/{main,sharedRegions,entities,stubs} dirBar/commInfra
cp serverSide/main/{BarMain,SimulPar,FunctionsIds}.class dirBar/serverSide/main
cp serverSide/sharedRegions/{Bar,BarInterface,SharedRegionInterface,IBar_Waiter}.class dirBar/serverSide/sharedRegions
cp serverSide/entities/{ServiceProviderAgent,Student,Chef,Waiter}.class dirBar/serverSide/entities
cp serverSide/stubs/GeneralReposStub.class dirBar/serverSide/stubs
cp commInfra/ServerCom.class dirBar/commInfra
cp genclass.jar dirBar/
echo "  Kitchen"
rm -rf dirKitchen
mkdir -p dirKitchen/serverSide/{sharedRegions,stubs,entities,main} dirKitchen/commInfra
cp serverSide/main/{KitchenMain,SimulPar,FunctionsIds}.class dirKitchen/serverSide/main
cp serverSide/sharedRegions/{Kitchen,KitchenInterface,SharedRegionInterface,IKitchen_Chef,IKitchen_Waiter}.class dirKitchen/serverSide/sharedRegions
cp serverSide/stubs/GeneralReposStub.class dirKitchen/serverSide/stubs
cp serverSide/entities/{ServiceProviderAgent,Student,Chef,Waiter}.class dirKitchen/serverSide/entities
cp commInfra/{CommunicationChannel,ServerCom,Message}.class dirKitchen/commInfra
cp genclass.jar dirKitchen/
echo "  Students"
rm -rf dirStudents
mkdir -p dirStudents/clientSide/{main,entities,stubs} dirStudents/commInfra
cp clientSide/main/{SimulPar,StudentMain}.class dirStudents/clientSide/main
cp clientSide/entities/Student.class dirStudents/clientSide/entities
cp clientSide/stubs/{TableStub,ITable_Student,ITable_Waiter}.class dirStudents/clientSide/stubs
cp commInfra/{CommunicationChannel,Message}.class dirStudents/commInfra
cp genclass.jar dirStudents/
echo "  Waiter"
rm -rf dirWaiter
mkdir -p dirWaiter/clientSide/{main,entities,stubs} dirWaiter/commInfra
cp clientSide/main/{SimulPar,WaiterMain}.class dirWaiter/clientSide/main
cp clientSide/entities/Waiter.class dirWaiter/clientSide/entities
cp clientSide/stubs/{Bar,Kitchen,Table}Stub.class dirWaiter/clientSide/stubs
cp clientSide/stubs/{ITable_{Waiter,Student},IKitchen_{Waiter,Chef},IBar_Waiter}.class dirWaiter/clientSide/stubs
cp commInfra/{CommunicationChannel,Message}.class dirWaiter/commInfra
cp genclass.jar dirWaiter/
echo "  Chef"
rm -rf dirChef
mkdir -p dirChef/clientSide/{main,entities,stubs} dirChef/commInfra
cp clientSide/main/{SimulPar,ChefMain}.class dirChef/clientSide/main
cp clientSide/entities/Chef.class dirChef/clientSide/entities
cp clientSide/stubs/{{{Kitchen,Table}Stub,IKitchen_{Waiter,Chef}},ITable_{Waiter,Student}}.class dirChef/clientSide/stubs
cp commInfra/{CommunicationChannel,Message}.class dirChef/commInfra
cp genclass.jar dirChef/
echo "Compressing execution environments"
echo "  General Repository of Information"
rm -f  dirGeneralRepos.zip
zip -rq dirGeneralRepos.zip dirGeneralRepos
echo "  Table"
rm -f  dirTable.zip
zip -rq dirTable.zip dirTable
echo "  Bar"
rm -f  dirBar.zip
zip -rq dirBar.zip dirBar
echo "  Kitchen"
rm -f  dirKitchen.zip
zip -rq dirKitchen.zip dirKitchen
echo "  Students"
rm -f  dirStudents.zip
zip -rq dirStudents.zip dirStudents
echo "  Waiter"
rm -f  dirWaiter.zip
zip -rq dirWaiter.zip dirWaiter
echo "  Chef"
rm -f  dirChef.zip
zip -rq dirChef.zip dirChef
