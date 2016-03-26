#!/bin/sh

TCUSR=$1
SRC=/tmp/particity
BIN=/opt/liferay/particity
DCFG=${SRC}/docker_config
BASE=/opt/liferay
LRDIR=$(/bin/ls -1p $BASE | grep / | grep liferay)
TCDIR=$(/bin/ls -1p $BASE/$LRDIR/ | grep / | grep tomcat)

# remove obsolete portlets
rm -rf ${BASE}/${LRDIR}/${TCDIR}/webapps/calendar-portlet \
       ${BASE}/${LRDIR}/${TCDIR}/webapps/sync-web \
       ${BASE}/${LRDIR}/${TCDIR}/webapps/opensocial-portlet \
       ${BASE}/${LRDIR}/${TCDIR}/webapps/web-form-portlet \
       ${BASE}/${LRDIR}/${TCDIR}/webapps/kaleo-web \
       ${BASE}/${LRDIR}/${TCDIR}/webapps/resources-importer-web

# create deploy directory
mkdir ${BASE}/${LRDIR}/deploy/

# compile, if source is present, use binaries otherwise
if [ -d ${SRC}/portlet_data/src ]; then
  cd ${SRC}
  mvn clean package install && cp deploy/*.war ${BASE}/${LRDIR}/deploy/
else
  find ${BIN} -name "*.war" | xargs -I , cp -v , ${BASE}/${LRDIR}/deploy/
fi

# assign deployed files to tomcat user
chown -R $TCUSR:$TCUSR ${BASE}/${LRDIR}/deploy

# copy default settings from docker environment
if [ ! -f ${BASE}/${LRDIR}/portal-setup-wizard.properties ]; then
  # copy dependencies over
  cp -Rv ${DCFG}/liferay/* ${BASE}/${LRDIR}/
  echo "liferay.home=${BASE}/${LRDIR}" >> ${BASE}/${LRDIR}/portal-setup-wizard.properties
fi 

# run
echo "Running tomcat inside ${BASE}/${LRDIR}/${TCDIR} as user $TCUSR"
/bin/su - -c "cd ${BASE}/${LRDIR}/${TCDIR}/bin && ./startup.sh" $TCUSR
tail -f ${BASE}/${LRDIR}/${TCDIR}/logs/catalina.out