package edu.emory.clinical.trials.webapp.server;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.emory.clinical.trials.webapp.server.xmlobject.ClinicalTrialXml;
import edu.emory.clinical.trials.webapp.server.xmlobject.Contact;
import edu.emory.clinical.trials.webapp.server.xmlobject.Eligibility;
import edu.emory.clinical.trials.webapp.server.xmlobject.Facility;
import edu.emory.clinical.trials.webapp.server.xmlobject.Location;
import edu.emory.clinical.trials.webapp.server.xmlobject.TextBlock;

public class ClinicalTrialsDataExtractorTest {
	
	private static ClinicalTrialXml clinicalTrialXml;

	@BeforeClass
	public static void getXMLData() throws Exception {
		JAXBContext context = JAXBContext.newInstance(ClinicalTrialXml.class);

		Unmarshaller unmarshaller = context.createUnmarshaller();

		String urlString = "https://clinicaltrials.gov/show/NCT01567462?displayxml=true";

		URL url = new URL(urlString);
		URLConnection connection = url.openConnection();

		clinicalTrialXml = (ClinicalTrialXml) unmarshaller.unmarshal(connection.getInputStream());
		
		Util.isTestMode = true;
	}


	@Test
	public void testExtractWithValidNctId() throws Exception {
		ClinicalTrialsDataExtractor ctExtract = new ClinicalTrialsDataExtractor();
		ctExtract.setTestNctId("NCT01567462");
		ctExtract.extract();
	}

	@Test
	public void testExtractWithInvalidNctId() throws Exception {
		ClinicalTrialsDataExtractor ctExtract = new ClinicalTrialsDataExtractor();
		ctExtract.setTestNctId("NCT0");
		ctExtract.extract();
	}
	
	@Test
	public void testConvertXmlWithLargeBriefSummary() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		TextBlock textBlock = new TextBlock();
		textBlock.setTextBlock("SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary"
				+ "SummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummarySummary");
		testXml.setBriefSummary(textBlock);
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testConvertXmlWithLargeEligibilityCriteria() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		TextBlock textBlock = new TextBlock();
		textBlock.setTextBlock("CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria"
				+ "CriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteriaCriteria");
		Eligibility eligibility = new Eligibility();
		eligibility.setCriteria(textBlock);
		testXml.setEligibility(eligibility);
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testFailResponsiblePartyTypeAndOfficialRoleCondition() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		testXml.getResponsibleParty().setResponsiblePartyType(""); // false
		testXml.getOverallOfficial().setRole(""); // false
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testFailResponsiblePartyAndOverallOfficialÅffiliationCondition() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		testXml.getResponsibleParty().setResponsiblePartyType("Principal Investigator"); //true
		testXml.getResponsibleParty().setInvestigatorAffiliation(""); //false
		testXml.getOverallOfficial().setRole("Principal Investigator"); //true
		testXml.getOverallOfficial().setAffiliation(""); //false
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testFailResponsiblePartyÅffiliationCondition() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		testXml.getResponsibleParty().setResponsiblePartyType("Principal Investigator"); //true
		testXml.getResponsibleParty().setInvestigatorAffiliation(""); //false
		testXml.getOverallOfficial().setRole("Principal Investigator"); //true
		testXml.getOverallOfficial().setAffiliation("Emory"); //true
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testLocationCondition() {
		
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		List<Location> locations = new ArrayList<Location>();
		Location testLocation = new Location();
		locations.add(testLocation);
		testXml.setLocations(locations);
		
		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testConvertXMLWithNullValues() {
		ClinicalTrialXml testXml = new ClinicalTrialXml(clinicalTrialXml);
		testXml.setResponsibleParty(null);
		testXml.setArmGroup(null);
		testXml.setBriefSummary(null);
		testXml.setConditionBrowse(null);
		testXml.setFacility(null);
		testXml.setInterventions(null);
		testXml.setInterventionBrowse(null);
		testXml.setKeywords(null);
		testXml.setLocations(null);
		testXml.setOverallContact(null);
		testXml.setOverallContactBackup(null);
		testXml.setOverallOfficial(null);
		testXml.setInterventions(null);
		testXml.setSecondaryOutcome(null);

		new ClinicalTrialsDataExtractor().convertXmlToStudyObject(testXml);
	}
	
	@Test
	public void testXMLWithNullValues() throws Exception {
		ClinicalTrialXml testXml = new ClinicalTrialXml();
		testXml.getInterventions();
		testXml.getEligibility();
		testXml.getFacility();
		testXml.setFacility(new Facility());
		testXml.getFacility();
		testXml.getKeywords();
		testXml.getConditionBrowse();
		testXml.getInterventionBrowse();
		testXml.getPrimaryOutcome();
		testXml.getOverallOfficial().getFirstName();
		testXml.getOverallOfficial().getLastName();
		testXml.getOverallOfficial().getAffiliation();
		testXml.getEligibility().getCriteria();
		testXml.getResponsibleParty().getInvestigatorAffiliation();
		testXml.getSponsors().getCollaborator();
	}
	
	@Test
	public void testContactXMLObject() {
		Contact contact = new Contact();
		contact.setFirstName("");
		contact.getFullName();
		contact.setFirstName("Bob");
		contact.getFullName();
	}
	
	
}
