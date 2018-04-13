FROM asciidoctor/docker-asciidoctor
MAINTAINER Cedric Gatay <c.gatay@code-troopers.com>

RUN apk update &&  apk add g++ nodejs nodejs-npm unzip vim ruby-dev
RUN gem install --no-ri --no-rdoc haml guard guard-shell guard-livereload guard-process yajl-ruby pygments.rb

RUN curl "https://codeload.github.com/chrisjaure/deckjs-remote/zip/master" -o master.zip\
        && unzip master.zip\
        && rm master.zip\
        && mv deckjs-remote-master /deck-remote\
        && cd /deck-remote\
        && npm install

ADD package.json /src/package.json
RUN cd /src \
    && npm install
RUN ln -s /documents /src/

ADD gulpfile.js /src
ADD gulp /src/gulp

RUN ln -s /src/node_modules/gulp/bin/gulp.js /usr/local/bin/gulp

EXPOSE 3000
EXPOSE 3001
EXPOSE 9010

# CMD ln -fs /deck-remote /documents/ && guard start --force-polling -i & ruby -run -e httpd . -p 9000& NODE_ENV=production node /deck-remote/server.js 9010
WORKDIR /src

RUN mkdir -p /src/deck-addons/split \
    && curl "https://raw.githubusercontent.com/houqp/deck.split.js/master/deck.split.js" -o /src/deck-addons/split/deck.split.js

ADD asciidoctor-deck.js /src/asciidoctor-deck.js
ADD documents /documents

ENV LC_ALL en_US.UTF-8

CMD ["gulp", "serve"]
