.SILENT :
.PHONY: master clean logs data start stop

NAME=bbl_jenkins

master : data
	docker pull codetroopers/jenkins-slave-jdk8-mvn
	docker run --name $(NAME) -d -p 9090:8080 --volumes-from $(NAME)-data agileek/docker-jenkins 
	echo "You can add a Maven job building a sample project on label jdk8 with manual cloning through shell pre step :"
	echo "git clone https://github.com/code-troopers/wicket-hot-reload.git ." 

start :
	docker start $(NAME)

stop :
	docker stop $(NAME)

logs :
	-docker logs -f $(NAME)

data :
	docker build -t $(NAME)-data-image -f Dockerfile-data .
	docker run -d --name $(NAME)-data $(NAME)-data-image true

clean : 
	docker rm -f $(NAME) $(NAME)-data
	docker rmi -f $(NAME)-data-image
