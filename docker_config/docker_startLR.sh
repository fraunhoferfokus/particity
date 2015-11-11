#!/bin/sh

TCUSR=$1
SRC=/tmp/particity
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

# copy WARs and LR config
if [ -d ${SRC} ]; then
  mkdir ${BASE}/${LRDIR}/deploy/
  find ${SRC} -name "*.war" | xargs -I , cp -v , ${BASE}/${LRDIR}/deploy/
  chown -R $TCUSR:$TCUSR ${BASE}/${LRDIR}/deploy
  if [ ! -f ${BASE}/${LRDIR}/portal-setup-wizard.properties ]; then
    # copy dependencies over
    cp -Rv ${DCFG}/liferay/* ${BASE}/${LRDIR}/
    echo "liferay.home=${BASE}/${LRDIR}" >> ${BASE}/${LRDIR}/portal-setup-wizard.properties
  fi 
fi

# run
echo "Running tomcat inside ${BASE}/${LRDIR}/${TCDIR} as user $TCUSR"
/bin/su - -c "cd ${BASE}/${LRDIR}/${TCDIR}/bin && ./startup.sh" $TCUSR
tail -f ${BASE}/${LRDIR}/${TCDIR}/logs/catalina.out