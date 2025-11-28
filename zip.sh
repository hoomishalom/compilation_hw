#!/bin/bash
n=$1
id=$(head -n 1 ids.txt | tr -d '\r')
zip "hw$n/$id.zip" ids.txt
cd "hw$n" && zip -r "$id.zip" "ex$n"
