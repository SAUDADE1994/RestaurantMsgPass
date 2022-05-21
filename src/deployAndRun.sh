#!/usr/bin/env bash
# Shared Regions
xterm  -T "General Repository" -hold -e "./GeneralReposDeployAndRun.sh" &
xterm  -T "Bar" -hold -e "./BarDeployAndRun.sh" &
xterm  -T "Kitchen" -hold -e "./KitchenDeployAndRun.sh" &
xterm  -T "Table" -hold -e "./TableDeployAndRun.sh" &

sleep 1

# Entities
xterm  -T "Student" -hold -e "./StudentDeployAndRun.sh" &
xterm  -T "Waiter" -hold -e "./WaiterDeployAndRun.sh" &
xterm  -T "Chef" -hold -e "./ChefDeployAndRun.sh" &