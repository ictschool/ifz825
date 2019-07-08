#!/bin/bash

for file in filea.txt fileb.txt filec.txt
do
fido=$(wget -b -q "http://www.svp-orpund.ch/?file=tl_files/svp-orpund/docs/events/FLYER-1.pdf" -O "File1.pdf" | grep -oE "[0-9]{4,6}")
echo -en "\033[s"
for i in {1..10}
do
	echo -en "\033[u$i"
	echo -en " ["
	for j in {1..10}
	do
		if [ $j -le $i ]
		then
			if [ $i -lt 5 ]
			then
				echo -en "\033[0;31m*\033[0m"
				elif [ $i -gt 7 ]
				then
					echo -en "\033[0;32m*\033[0m"	
				else 
				echo -en "*"
			fi
			else
			echo -en " "
		fi
	done
	echo -en "] File $file downloading..." 
	if [ ! -z $(ps -eo pid | grep -o $fido) ]
	then
		sleep 1
	fi
done
echo ""
done
