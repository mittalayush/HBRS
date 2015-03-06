 package geoLocation;
 import geoCode.Geo;
 import org.codehaus.jackson.annotate.JsonIgnore;
 public class Result {
 private String formatted_address;
 private boolean partial_match;
 private Geo geometry;
 private String place_id;
 
@JsonIgnore
 private Object address_components;
 
 @JsonIgnore
 private Object types;

 public String getFormatted_address() {
  return formatted_address;
 }

 public void setFormatted_address(String formatted_address) {
  this.formatted_address = formatted_address;
 }

 public boolean isPartial_match() {
  return partial_match;
 }

 public void setPartial_match(boolean partial_match) {
  this.partial_match = partial_match;
 }

 public Geo getGeometry() {
  return geometry;
 }

 public void setGeometry(Geo geometry) {
  this.geometry = geometry;
 }

 public Object getAddress_components() {
  return address_components;
 }

 public void setAddress_components(Object address_components) {
  this.address_components = address_components;
 }

 public Object getTypes() {
  return types;
 }

 public void setTypes(Object types) {
  this.types = types;
 }
 
 public String getPlace_id() {
		return place_id;
	}

public void setPlace_id(String place_id) {
		this.place_id = place_id;
	}
}