### Pull image
FROM docker-registry.cc.emory.edu:443/clinical-trials-primer

### Swap out the updated clinicalTrials.war
ADD target/clinicalTrials.war /opt/jboss/jboss-eap-6.4/standalone/deployments/clinicalTrials.war
