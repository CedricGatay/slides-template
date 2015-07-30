.SILENT :
.PHONY: master clean logs

NAME=bbl_jenkins

master : jenkins
	docker pull codetroopers/jenkins-slave-jdk8-mvn
	docker run --name $(NAME) -d -p 9090:8080 -v $(shell pwd)/jenkins:/var/jenkins_home agileek/docker-jenkins 
	echo "You can add a Maven job building a sample project on label jdk8 with manual cloning through shell pre step :"
	echo "git clone https://github.com/code-troopers/wicket-hot-reload.git ." 

jenkins : 
	mkdir jenkins && cp -R base/* jenkins

logs :
	-docker logs -f $(NAME)

clean : 
	docker rm -f $(NAME)
	rm -rf jenkins
