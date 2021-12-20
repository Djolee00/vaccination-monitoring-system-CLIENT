
# Vaccination monitoring system - CLIENT

This is a client side for console application with client/server architecture. It allows users to register and enter data about their vaccination status and then log in with their profile to see their own info and change them. There is also a special user called Admin, who can see some stats about vaccionation of registered users.


## Features

- Registration
- Log in
- Log in as Admin
- Data validation
- Covid certificate generation (.txt file)
- Communication can be interrupted at any time
- Using threads to read from server and write to server simultaneously


## Run Locally

Clone the server side of application

```bash
  git clone https://github.com/Djolee00/vaccination-monitoring-system-SERVER.git
```

Clone the client side of application

```bash
  git clone https://github.com/Djolee00/vaccination-monitoring-system-CLIENT.git
```

Start the server in any IDE for Java



Start the client in any IDE for Java




## Purpose 

The main purpose of this application was to learn how to use sockets and manage TCP communcation between client and server. Server can communicate in the same time with multiple clients. Also every exception is carefully handled. I was dealing with MySQL databsase for the first time and it was also a grate challange.
