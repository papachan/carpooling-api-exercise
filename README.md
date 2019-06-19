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
lein upgrade
```

That's it !


## Run this project

You can run now this project as this:

```
$ lein run
```

And your server start at port 3000 and is available at `http://localhost:3000`.

## Swagger UI

You can access Swagger api doc visiting this page here: `http://localhost:3000`.

## Usage

How to use this service.

#### List of Passengers

A list of passengers

`http://localhost:3000/passengers`


### List of Drivers

A list of Drivers near.

`http://localhost:3000/drivers`


### Tests

Run project's tests using this command:

```
lein test
```
This project implement `lein-test-refresh` plugin:

```
lein test-refresh
```

## Author

Dan Loaiza (papachan @ gmail.com).

## Licence

Copyright © 2019 Dan Loaiza <papachan@gmail.com>

Distributed under the Eclipse Public License, the same as Clojure uses.
