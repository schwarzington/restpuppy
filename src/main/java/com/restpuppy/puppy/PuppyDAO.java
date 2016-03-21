package com.restpuppy.puppy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;

import com.restpuppy.solr.PuppyScannerSolrUtil;

public class PuppyDAO {
	static String urlString = "http://localhost:8983/solr/puppyscanner";
	static final Logger logger = LogManager.getLogger(PuppyScannerSolrUtil.class.getName());
	static SolrClient solr = new HttpSolrClient(urlString);
	public static ArrayList<Puppy> getAllPuppies(){
		ArrayList<Puppy> puppies = new ArrayList<Puppy>();
		SolrQuery query = new SolrQuery().setRows(5000);
		query.set("q", "*:*");
		QueryResponse rsp = null;
		try {
			rsp = solr.query(query);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<SolrDocument> iter = rsp.getResults().iterator();
		int count = 0;
		while (iter.hasNext()) {
			SolrDocument resultDoc = iter.next();
			String id = (String) resultDoc.getFieldValue("id");
			ArrayList<String> names = (ArrayList<String>) resultDoc.getFieldValue("name");
			String name = names.get(0);
			boolean gender = (Boolean) resultDoc.getFieldValue("sex");
			int age = (Integer) resultDoc.getFieldValue("age");
			ArrayList<String> breeds = (ArrayList<String>) resultDoc.getFieldValue("breed");
			String[] breed = breeds.toArray(new String[breeds.size()]);
			Puppy puppy = new Puppy(name, gender, age, breed);
			puppies.add(puppy);
			count++;
		}
		System.out.println(count);
		return puppies;
	}
}
