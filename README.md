# particity
Participatory marketplace for voluntary services/donations

## Notes
See site documentation for further documentation.
   
## How to generate site documentation
For generating the site documentation (results in target/staging), do a
```
  mvn jxr:jxr site site:stage
```

Optionally, for using the site documentation within the (unofficial) site portlet do
```
  cp -R target/staging/* ah_portlet_site/src/main/webapp/docs/
  cd ah_portlet_site
  mvn clean package
```
Then deploy the WAR file in ah_portlet_site/target/ to your Liferay instance
