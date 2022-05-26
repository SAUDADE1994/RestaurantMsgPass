#!/usr/bin/env bash
# Parameters
DIRNAME='dirTable'
DESCRIBE='table'
MAIN='serverSide.main.TableMain'
USER="sd209@l040101-ws01.ua.pt"
PORT='22380'

source NodeDeployAndRun.sh "$DIRNAME" "$DESCRIBE" "$MAIN" "$USER" "$PORT"
