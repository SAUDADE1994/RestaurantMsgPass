#!/usr/bin/env bash
echo "Compiling source code."
javac -- */*.java -- */*/*.java
echo "Distributing intermediate code to the different execution environments."
echo "  General Repository of Information"
rm -rf dirGeneralRepos
mkdir -p dirGeneralRepos/serverSide/{main,entities,sharedRegions} dirGeneralRepos/commInfra dirGeneralRepos/clientSide/entities
cp serverSide/main/{SimulPar,GeneralReposMain}.class dirGeneralRepos/serverSide/main
cp serverSide/entities/ServiceProviderAgent.class dirGeneralRepos/serverSide/entities
cp serverSide/sharedRegions/{GeneralRepos,GeneralRepos,SharedRegionInterface}.class dirGeneralRepos/serverSide/sharedRegions
cp clientSide/entities/ServiceProviderAgent.class dirGeneralRepos/clientSide/entities
cp commInfra/ServerCom.class dirGeneralRepos/commInfra
echo "  Table"
rm -rf dirTable
mkdir -p dirTable/serverSide/{main,entities,sharedRegions,stubs}
cp serverSide/main/{TableMain,SimulPar,FunctionIds}.class dirTable/serverSide/main
cp serverSide/entities/ServiceProviderAgent.class dirTable/serverSide/entities
cp serverSide/sharedRegions/{Table,TableInterface,SharedRegionInterface}.class dirTable/serverSide/sharedRegions
cp serverSide/stubs/GeneralReposStub.class dirTable/serverSide/stubs
echo "  Bar"
rm -rf dirBar
mkdir -p dirBar/serverSide/{main,sharedRegions,entities,stubs}
cp serverSide/main/{BarMain,SimulPar,FunctionIds}.class dirTable/serverSide/main
cp serverSide/sharedRegions/{Bar,BarInterface,SharedRegionInterface}.class dirTable/serverSide/sharedRegions
cp serverSide/entities/ServiceProviderAgent.class dirTable/serverSide/entities
cp serverSide/entities/GeneralReposStub.class dirTable/serverSide/stubs
echo "  Kitchen"
rm -rf dirKitchen
mkdir -p dirKitchen/serverSide/{sharedRegions,stubs,entities,main} dirKitchen/commInfra
cp serverSide/main/{KitchenMain,SimulPar,FunctionIds}.class dirTable/serverSide/main
cp serverSide/sharedRegions/{Kitchen,KitchenInterface,SharedRegionInterface}.class dirKitchen/serverSide/sharedRegions
cp serverSide/stubs/GeneralReposStub.class dirKitchen/serverSide/stubs
cp serverSide/entities/ServiceProviderAgent.class dirKitchen/serverSide/entities
cp serverSide/commInfra/ServerCom.class dirKitchen/commInfra
echo "  Students"
rm -rf dirStudents
mkdir -p dirStudents/clientSide/{main,entities,stubs}
cp clientSide/main/{SimulPar,StudentMain}.class dirStudents/clientSide/main
cp clientSide/entities/Student.class dirStudents/clientSide/entities
cp clientSide/stubs/TableStub.class dirStudents/clientSide/stubs
echo "  Waiter"
rm -rf dirWaiter
mkdir -p dirWaiter/clientSide/{main,entities,stubs}
cp clientSide/main/{SimulPar,WaiterMain}.class dirWaiter/clientSide/main
cp clientSide/entities/Waiter.class dirWaiter/clientSide/entities
cp clientSide/stubs/{Bar,Kitchen,Table}Stub.class dirWaiter/clientSide/stubs
echo "  Chef"
rm -rf dirChef
mkdir -p dirChef
cp clientSide/main/{SimulPar,ChefMain}.class dirChef/clientSide/main
cp clientSide/entities/Chef.class dirChef/clientSide/entities
cp clientSide/stubs/{Kitchen,Table}Stub.class dirChef/clientSide/stubs
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
