#!/usr/bin/env bash
# Parameters
DIRNAME='dirBar'
DESCRIBE='bar'
MAIN='serverSide.main.BarMain'
USER="sd209@l040101-ws02.ua.pt"
PORT='22381'

source NodeDeployAndRun.sh "$DIRNAME" "$DESCRIBE" "$MAIN" "$USER" "$PORT"
