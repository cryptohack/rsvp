#!/bin/bash -e

: "${CERT_EMAIL:?Expecting CERT_EMAIL to be set}"

# lein uberjar

sudo yum install ansible

ansible-playbook -i hosts provisioning/deploy.yml
