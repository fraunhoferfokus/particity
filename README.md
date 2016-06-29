# particity
Participatory marketplace for voluntary services/donations

## About branch v095
We are currently not on schedule for v0.9.5 because Liferay 7 is out and while migrating to the new and exciting features we were also
facing the well known lack of documentation on latest changes. Due to the fact that we had rather complex requirements for the database tier
it was decided to abandon Liferay's service-builder in favor of a more basic setup using JPA/Hibernate and Deltaspike. This change reduces
code complexity by a huge deal and alongside our integration of CDI/Weld makes the whole platform a lot easier to develop and maintain
while at the same time catching up with up to date standards of coding techniques and quality. In future terms this will also ease
testing and maybe even porting things to other products.

So long text, short message: Stay tuned, as we hope to be right on track soon.

TODOs/DONEs
 - [x] Update libraries to LR7
 - [x] JPA models, controllers
 - [x] Deltaspike integration
 - [x] CDI integration
 - [x] Liquibase integration
 - [x] ServiceBuilder removed
 - [x] Native Queries from ServiceBuilder to PSQL/Deltaspike 
 - [x] JSPs updated for new backend
 - [ ] Theme migration to LR7
 - [ ] Layout migration to LR7
 - [x] Compiles
 - [ ] Deploys
 - [ ] Installs
 - [ ] Management tested
 - [ ] Organisations tested
 - [ ] Users tested
 - [ ] Newsletter tested
 - [ ] Search tested 
 - [ ] TW/FB-Integration tested

## License
Particity is released under a [3-clause BSD](http://opensource.org/licenses/BSD-3-Clause)

## Documentation
Currently, there are several sources for documentation
 - The [GitHub wiki](https://github.com/fraunhoferfokus/particity/wiki), to become the one-stop documentation site for future releases
 - The maven-generated project site on the [GitHub pages](https://fraunhoferfokus.github.io/particity/index.html) including JavaDoc   
 - The original [project announcement](https://www.oeffentliche-it.de/machmitboerse) at the Kompetenzzentrum Öffentliche IT (german only)

## Demo site
A demo site is available over [here](http://193.175.133.70), hosted by the [Kompetenzzentrum Öffentliche IT](https://www.oeffentliche-it.de)  

Username | Password  | Role
---------|-----------|-----
ericka.mustermann@particity.de | test | Organization
siegfried.lebewohl@particity.de | test | Bureau (Management/Administration/Moderation) 
