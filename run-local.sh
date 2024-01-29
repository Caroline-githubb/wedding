#!/bin/bash

cert_password=$1

docker run \
    -p 8443:8443 \
    -p 8080:8080 \
    -e MERCADO_PAGO_ACCESS_TOKEN=abc \
    -e CERT_PASSWORD=$cert_password \
    -e HTTPS_REDIRECT_PORT=443 \
    casamentocarolerodrigo casamento