package org.zpid.se4ojs.annotation;

import java.util.NoSuchElementException;

public enum Prefix {
	
    AO("http://purl.org/ao/core/", "ao"),
	
	AOA ("http://purl.org/ao/annotea/", "aoa"),
    
    AOS ("http://purl.org/ao/selectors/", "aos"),
    
    AOT ("http://purl.org/ao/types/", "aot"),
    
    BIOTEA ("http://www.biotea.ws/ontology/ao_biotea.owl#", "biotea"),
    
	DC("http://purl.org/dc/elements/1.1/", "dc"),

	DCTERMS("http://purl.org/dc/terms/", "dcterms"),
	
	DOCO("http://purl.org/spar/doco/", "doco"),
	
    FRBR("http://purl.org/vocab/frbr/core#", "frbr"),
	// Content in RDF
	OWL("http://www.w3.org/2002/07/owl#", "owl"),
	
    PAV("http://purl.org/pav/", "pav"),
    
	PO ("http://www.essepuntato.it/2008/12/pattern#", "po"),
	// PROV
	PROV("http://www.w3.org/ns/prov#", "prov"),

	PSYNDEX("http://www.zpid.de/psyndex#", "psyndex"),
	
	RDF("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf"), 
	
	RDFS("http://www.w3.org/2000/01/rdf-schema#", "rdfs"),
	
	SKOS ("http://www.w3.org/2004/02/skos/core#", "skos"),
	
    SRO("http://salt.semanticauthoring.org/ontologies/sro#", "sro"),
	ZPID("http://www.zpid.de/resource", "zpid"),
	
	//Extended SPAR ontology
	ZPID_DOCO("http://www.zpid.de/zpid_doco#", "zpid_doco"),

	;

	private String url;
	private String ns;

	private Prefix(String url, String ns) {
		this.url = url;
		this.ns = ns;
	}

	public String getURL() {
		return (this.url);
	}

	public String getNS() {
		return (this.ns);
	}

	public String getPrefix() {
		return "PREFIX " + this.ns + ":<" + this.url + "> ";
	}

	public static Prefix getByNS(String ns) throws NoSuchElementException {
		for (Prefix prefix : Prefix.values()) {
			if (prefix.getNS().equals(ns)) {
				return prefix;
			}
		}
		throw new NoSuchElementException("The prefix with NS " + ns
				+ " cannot be resolved.");
	}
}
