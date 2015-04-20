FROM asciidoctor/docker-asciidoctor
MAINTAINER Cedric Gatay <c.gatay@code-troopers.com>

RUN yum install -y gcc-c++
RUN gem install --no-ri --no-rdoc haml guard guard-shell guard-livereload yajl-ruby pygments.rb

EXPOSE 9000
EXPOSE 35729

CMD guard start -i & ruby -run -e httpd . -p 9000