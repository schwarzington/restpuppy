package com.restpuppy.puppy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.restpuppy.solr.PuppyScannerSolrUtil;

public class PuppyDAO {
	String urlString = "http://localhost:8983/solr/puppyscanner";
	static final Logger logger = LogManager.getLogger(PuppyScannerSolrUtil.class.getName());
	SolrClient solr = new HttpSolrClient(urlString);
}
