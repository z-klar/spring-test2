PORT: 9000

REST EndPoints:
===============
/main/{id}:  			returns ID if number, otherwise error
/main/ping/{ipAddr}:	tries to ping given addr by launching sys comman PING
						with param either "-c 2" (Linux) or "-n 2" (windows)
						if the returned output contains "TTL" or "ttl" it is
						evaluated as success (returns TRUE), else not
						