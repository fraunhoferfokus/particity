FROM ubuntu:14.04
MAINTAINER particity

# Install dependencies and upgrade everything to latest versions 
RUN apt-get -qq update \
    && DEBIAN_FRONTEND=noninteractive apt-get -qq install -y --no-install-recommends openjdk-7-jdk unzip wget maven2 \ 
    && rm -rf /var/lib/apt/lists/*

# Get & extract liferay
#
RUN mkdir -p /opt/liferay/particiy \
    && wget -c http://downloads.sourceforge.net/project/lportal/Liferay%20Portal/6.2.5%20GA6/liferay-portal-tomcat-6.2-ce-ga6-20160112152609836.zip \
    && unzip liferay-portal-tomcat-6.2-ce-ga6-20160112152609836.zip -d /opt/liferay \ 
    && wget -c https://github.com/fraunhoferfokus/particity/releases/download/v0.9.4-rc1/particity_0.9.4-rc1.zip
    && unzip particity_0.9.4-rc1.zip -d /opt/liferay/particity
    
# Add user
RUN groupadd -r tomcat \
    && useradd -r -g tomcat tomcat \
    && chown -R tomcat:tomcat /opt/liferay

# Expose default Liferay port
EXPOSE 8080

# Create working directory and add source
# Note: If source actually contains a git clone, it will be compiled -
#       which will take quite some time (and bandwidth+space), otherwise
#       you may only keep this Dockerfile along with docker_config
#       and we'll detect this and use the binaries (downloaded above) instead
ADD ./ /tmp/particity

# Force executable
RUN chmod +x /tmp/particity/docker_config/docker_startLR.sh

# Start tomcat & tail output
CMD /tmp/particity/docker_config/docker_startLR.sh tomcat