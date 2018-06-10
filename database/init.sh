#!/usr/bin/env bash
function exec_file {
    echo "file: $1"
    psql -U $POSTGRES_USER -d $POSTGRES_DB -f $1
}

function exec_folder {
  echo "folder: $1"
  for file in $(find $1 -name "*.sql")
  do
    exec_file $file
  done
}


BASEDIR=$(dirname $0)
POSTGRES_USER=postgres
POSTGRES_DB=ecomap
# recreate db on local machine
dropdb $POSTGRES_DB -U $POSTGRES_USER
createdb $POSTGRES_DB -U $POSTGRES_USER

exec_folder $BASEDIR/scripts/