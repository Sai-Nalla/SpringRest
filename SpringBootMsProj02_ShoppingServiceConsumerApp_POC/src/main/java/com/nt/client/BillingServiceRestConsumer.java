package com.nt.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



//developed this class to fetch and get the details of ProviderMs Instance details

@Component
public class BillingServiceRestConsumer {
	
	@Autowired
	//private DiscoveryClient client;			//cient comp
	private LoadBalancerClient client;
	
		public String getBillingInfo() {
			/*
			 // using Discovery Client Comp
			 
			//find and get service instance of Producer MS
			List<ServiceInstance> listSI=client.getInstances("Billing-Service");
			//use firstServiceInst from the List of Instances
			ServiceInstance SI=listSI.get(0);
			
			*/
			
			//using LoadBalancerClient Comp
			
			ServiceInstance SI=client.choose("Billing-Service");
			
			//get Producet Ms uri and make to url
			
			String url=SI.getUri()+"/billing/info";
			//create restTemplate Object
			RestTemplate template=new RestTemplate();
			//Invoke Producer MS service method by generating http call
			String resp=template.getForObject(url, String.class);
			return resp;
			
		}

}
