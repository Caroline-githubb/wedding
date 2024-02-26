MERCADO_PAGO_ACCESS_TOKEN=$1

docker run \
    -e MERCADO_PAGO_ACCESS_TOKEN=$MERCADO_PAGO_ACCESS_TOKEN \
    -p 8080:8080 \
    -p 8443:8443 \
    casamentocarolerodrigo