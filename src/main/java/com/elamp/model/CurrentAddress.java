package com.elamp.model;

import java.util.HashMap;
import java.util.Map;

public class CurrentAddress {

private String id;
private String location_type;
private String street_line_1;
private Object street_line_2;
private String city;
private String postal_code;
private String zip4;
private String state_code;
private String country_code;
private LatLong lat_long;
private Boolean is_active;
private String delivery_point;
private String link_to_person_start_date;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getLocation_type() {
	return location_type;
}
public void setLocation_type(String location_type) {
	this.location_type = location_type;
}
public String getStreet_line_1() {
	return street_line_1;
}
public void setStreet_line_1(String street_line_1) {
	this.street_line_1 = street_line_1;
}
public Object getStreet_line_2() {
	return street_line_2;
}
public void setStreet_line_2(Object street_line_2) {
	this.street_line_2 = street_line_2;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPostal_code() {
	return postal_code;
}
public void setPostal_code(String postal_code) {
	this.postal_code = postal_code;
}
public String getZip4() {
	return zip4;
}
public void setZip4(String zip4) {
	this.zip4 = zip4;
}
public String getState_code() {
	return state_code;
}
public void setState_code(String state_code) {
	this.state_code = state_code;
}
public String getCountry_code() {
	return country_code;
}
public void setCountry_code(String country_code) {
	this.country_code = country_code;
}
public LatLong getLat_long() {
	return lat_long;
}
public void setLat_long(LatLong lat_long) {
	this.lat_long = lat_long;
}
public Boolean getIs_active() {
	return is_active;
}
public void setIs_active(Boolean is_active) {
	this.is_active = is_active;
}
public String getDelivery_point() {
	return delivery_point;
}
public void setDelivery_point(String delivery_point) {
	this.delivery_point = delivery_point;
}
public String getLink_to_person_start_date() {
	return link_to_person_start_date;
}
public void setLink_to_person_start_date(String link_to_person_start_date) {
	this.link_to_person_start_date = link_to_person_start_date;
}
public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}
public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}


}

