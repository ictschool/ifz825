#!/bin/bash

users=$(grep -E "x:[0-9]{4,4}:" /etc/passwd | cut -d':' -f1,6)

for user in $(echo $users)
do
	username=$(echo $user | cut -d':' -f1)
	home=$(echo $user | cut -d':' -f2)

	hasuser=$(sqlite3 mydatabase.db "select id from user where name='$username';")
	if [ -z "$hasuser" ]
	then
	sqlite3 mydatabase.db <<EOF
	insert into user (name,home) values ('$username','$home');
EOF
	hasuser=$(sqlite3 mydatabase.db "select id from user where name='$username';")
	fi
	
	groups=$(grep -oE "^$username" /etc/group)
	
	for group in $(echo $groups)
	do
		hasgroup=$(sqlite3 mydatabase.db "select id from \`group\` where userFk = $hasuser and name = '$group';")

		if [ -z "$hasgroup" ]
		then
			sqlite3 mydatabase.db <<EOF
			insert into \`group\` (userFk, name) values ($hasuser, '$group');
EOF
		fi

	done

done

sqlite3 mydatabase.db "select * from user left join \`group\` on user.id=\`group\`.userFk;"
