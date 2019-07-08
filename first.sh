#!/bin/bash

#if [ $# -gt 0 ] # zahlenvergleich -gt >, -gte >=, -lt <, -lte <=, -eq =
# if [ "$name" = "Buchs" ] #string vergleich
# if [ -f /home/ebuchs/text.txt ] # ist ein dokument
# if [ -d /home/ebuchs ] # ist ein verzeichnis
# if [ -e /home/ebuchs ] # existiert die datei 
# if [ -z "$name" ] #ist string leer
# if [ "$name" = "Buchs" -o ( "$name" = "Enrico" ) ] # -o || -a &&

if [ $# -eq 0 ]
then
	echo "Mindestens ein Argument muss übergeben werden"
	exit 0
	elif [ $# -eq 1 ]
	then
		echo "Exakt ein Argument wurde übergeben"
	else
		echo "Bravo sie können das Skript ausführen"
fi

case $1 in
	*35) echo "Sie sind genug alt" ;;
	"*auto"|"velo*") echo "irgend ein mobil" ;;
	*) echo "Sie auch" ;;
esac

for i in {1..10}
do
	echo $i
done

for i in auto velo mofa motorrad
do
	echo $i
done

echo "Hallo Welt"

read -p "Namen eingeben: " name

echo "Sie heissen $name $1"
echo "Es wurden $# Argumente übergeben"
