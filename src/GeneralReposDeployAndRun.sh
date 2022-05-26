#!/usr/bin/env bash
# Parameters
DIRNAME='dirGeneralRepos'
DESCRIBE='general repository'
MAIN='serverSide.main.GeneralReposMain'
USER="sd209@l040101-ws04.ua.pt"
PORT='22383'

source NodeDeployAndRun.sh "$DIRNAME" "$DESCRIBE" "$MAIN" "$USER" "$PORT"
