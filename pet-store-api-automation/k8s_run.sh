#!/bin/bash

STATUSFILE=/tmp/status

mvn verify -Dcucumber.options="--tags @iceland --tags @dev" -Pdev
MVNEXIT=$?

tar czf /tmp/report.tgz --directory /builds/QA/bink-banking-api-automation/target/cucumber-html-reports .

if [ $MVNEXIT -eq 0 ]
then
    touch $STATUSFILE
    echo '0' > $STATUSFILE
else
    touch $STATUSFILE
    echo '1' > $STATUSFILE
fi
