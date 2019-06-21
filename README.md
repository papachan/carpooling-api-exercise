# Car pooling Proxy API

A web service to get structured data from Icelandic car pooling API.

## Introduction

This service provide a JSON API that extend Icelandic car pooling API. It have been written in Clojure.

## Requirements

You need to install clojure and leiningen. You can install clojure and leiningen using brew.

You are under Macos X, this what you need:

```
$ brew cask install java
```

```
$ brew install leiningen
```

```
$ brew install clojure
```

You are using a linux box, install Clojure on your box as this:

```
$ sudo apt-get install rlwrap
$ curl -O https://download.clojure.org/install/linux-install-1.10.0.403.sh
$ chmod +x linux-install-1.9.0.397.sh
$ sudo ./linux-install-1.9.0.397.sh
```

Install Leiningen manually:

```
mkdir ~/bin
curl -o ~/bin/lein https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && chmod a+x ~/bin/lein
```
Add your bin directory to your PATH: `export PATH=$PATH:~/bin`.

And check out the lein's latest version:

```
$ lein upgrade
```

That's it !


## Run this project

You can run now this project as this:

```
$ lein run
```

And your server run at port 3000.

## Swagger UI

You can access Swagger api doc visiting this page here: http://localhost:3000/index.html.

## Usage

How to use this service.

A list of endpoints:

**List of Passengers**
_A list of passengers and their rides data info._

Method:

`GET`

```
curl -X GET http://localhost:3000/passengers
```

**Response**


Return a Json response:

```
{"response": [{"...data..."}]}
```


**List of Drivers**
_A list of nearest Drivers with their rides_

Method:

`GET`


```
curl -X GET http://localhost:3000/drivers
```

**Response**


Return a Json Response:

```
{"response": [{"...data..."}]}
```

### Testing

Run project's tests using this command:

```
$ lein test
```

This project implement `lein-test-refresh` plugin, if you want to use
it, i recommend this command:

```
$ lein test-refresh
```

## Release

To release a build use this command:

```
$ lein uberjar
```

And execute your jar file with this command:

```
$ java -jar mobytronics-0.1.0-SNAPSHOT-standalone.jar
```

## Author

Dan Loaiza (papachan @ gmail.com).

## Licence

Copyright © 2019 Dan Loaiza <papachan@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure uses.
