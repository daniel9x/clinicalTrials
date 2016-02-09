### Pull image
FROM docker-registry.cc.emory.edu:443/clinical-trials-webapp

### Swap out the updated ClinicalTrials.war
<<<<<<< .merge_file_J4TE8H
ADD target/clinicalTrials.war /opt/jboss/jboss-eap-6.4/standalone/deployments/clinicalTrials.war
=======
ADD target/clinicalTrials.war /opt/jboss/jboss-eap-6.4/standalone/deployments/clinicalTrials.war
>>>>>>> .merge_file_bpmtMs
