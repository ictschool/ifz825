#!/bin/bash

IFS=$'\n'

source=~/Downloads

for filesource in $(ls $source)
do
	mime=$(file --mime-type $source/"$filesource")
	folder=""
	case $mime in
	*/pdf) mkdir -p $source/pdf ; folder=$source/pdf ;;
	*/zip|*/x-rar|*/x-gzip) mkdir -p $source/archive ; folder=$source/archive ;;
	*spreadsheetml*) mkdir -p $source/excel ; folder=$source/excel ;;
	*wordprocessingml*) mkdir -p $source/word ; folder=$source/word ;;
	*presentationml*) mkdir -p $source/powerpoint ; folder=$source/powerpoint ;;
	*/octet-stream) mkdir -p $source/octet ; folder=$source/octet ;;
	*text/plain) mkdir -p $source/text ; folder=$source/text ;;
	*image/*) mkdir -p $source/bilder ; folder=$source/bilder ;;
	*) mkdir -p $source/divers ; folder=$source/divers ;;
	esac

	if [ ! -z $folder -a -f $source/"$filesource" ]
	then
		mv $source/"$filesource" $folder/"$filesource"
	fi

done
