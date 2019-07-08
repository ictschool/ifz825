#!/bin/bash

next="y"
while [ "$next" = "y" ]
do
	zufallszahl=$((${RANDOM} % 100 + 1))
	anzahlVersuche=1
	while [ 1 ]
	do
		read -p "Zahl raten: " ratezahl
		if [ $ratezahl -eq $zufallszahl ]
		then
			echo "Bravo $zufallszahl in $anzahlVersuche gefunden"
			break
			elif [ $ratezahl -lt $zufallszahl ]
			then
				echo "Gesuchte Zahl ist grösser"
			else
				echo "Gesuchte Zahl ist kleiner"
		fi
		anzahlVersuche=$(($anzahlVersuche+1))
	done
	read -p "Möchten Sie weiterspielen (y|n): " next
done


