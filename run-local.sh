#!/bin/bash

env_file=$1

docker run \
    -d --restart unless-stopped \
    -p 8443:8443 \
    -p 8080:8080 \
    --env-file "$env_file" \
    casamentocarolerodrigo casamento