#! /bin/sh

./clean.sh
./process.sh
./report.sh

try
    firefox index.html
