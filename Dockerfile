FROM ubuntu:14.04
MAINTAINER particity

# Install dependencies and upgrade everything to latest versions 
RUN apt-get -qq update \
    && DEBIAN_FRONTEND=noninteractive apt-get -qq install -y --no-install-recommends openjdk-7-jdk unzip wget maven2 \ 
    && rm -rf /var/lib/apt/lists/*

# Get & extract liferay
#
RUN mkdir -p /opt/liferay \
    && wget -c http://downloads.sourceforge.net/project/lportal/Liferay%20Portal/6.2.5%20GA6/liferay-portal-tomcat-6.2-ce-ga6-20160112152609836.zip \
    && unzip liferay-portal-tomcat-6.2-ce-ga6-20160112152609836.zip -d /opt/liferay
    
# Add user
RUN groupadd -r tomcat \
    && useradd -r -g tomcat tomcat \
    && chown -R tomcat:tomcat /opt/liferay

# Expose default Liferay port
EXPOSE 8080

# Create working directory
ADD ./ /tmp/particity

# Compile stuff
WORKDIR /tmp/particity
RUN mvn clean package install

# Force executable
RUN chmod +x /tmp/particity/docker_config/docker_startLR.sh

# Start tomcat & tail output
CMD /tmp/particity/docker_config/docker_startLR.sh tomcat