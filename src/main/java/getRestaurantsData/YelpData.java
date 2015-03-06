package getRestaurantsData;

public class YelpData
{	
	String name;

	double latitude;
	double longitude;
	String address;
	String zip;
	float distance;
	float rating;
	String cuisine;
	String phone;
	
	public YelpData(String name,
				double latitude,
				double longitude,
				String address,
				String zip,
				float distance,
				float rating,
				String cuisine,
				String phone)
	{
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
		this.zip = zip;
		this.distance = distance;
		this.rating = rating;
		this.cuisine = cuisine;
		this.phone = phone;	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
