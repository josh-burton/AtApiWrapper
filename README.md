#AtApiWrapper

##About

The AtApiWrapper is a android library that is a wrapper around the [Auckland Transport public api](https://api.at.govt.nz).

Retrofit is used under the hood to perform all requests, which in turn uses OkHttp.

I reccommend having a read through the [Retrofit docs](http://square.github.io/retrofit/).


##Available endpoints

* Realtime
* GTFS

##How to use


You must first have an api key. You can get one from [here](https://api.at.govt.nz).

### Synchronously

	//construct api object with our api key
	AtApi api = new AtApi(apiKey);
	
	//get the 	realtime service
	RealtimeService realtimeService = api.getRealtimeService(); 
	
	//get vehicle locations synchronously
	return realtimeService.vehiclelocations();


### Asynchronously

	//construct api object with our api key
	AtApi api = new AtApi(apiKey);
	
	//get the 	realtime service
	RealtimeService realtimeService = api.getRealtimeService(); 
	
	//get vehicle locations asynchronously, by passing in an retrofit Callback object
	realtimeService.vehiclelocations(callback);
	
	
###Running the sample app

The sample app is simple a practical example of how to query the api. It would be better just to look through the code, but if you do want to run the app, you will need to add your api key to the **VehicleLocationListFragment**.



###How to include in your project


###1. As a jar
Get the jar from the downloads page

	
	




