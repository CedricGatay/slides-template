FROM asciidoctor/docker-asciidoctor
MAINTAINER Cedric Gatay <c.gatay@code-troopers.com>

RUN gem install --no-ri --no-rdoc haml

EXPOSE 9000

ADD . /documents/
RUN asciidoctor -T asciidoctor-backends/haml slides.adoc -o index.html
CMD ruby -run -e httpd . -p 9000