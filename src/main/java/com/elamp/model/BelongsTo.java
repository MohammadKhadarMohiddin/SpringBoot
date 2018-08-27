package com.elamp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BelongsTo {

private String id;
private String name;
private Object firstname;
private Object middlename;
private Object lastname;
private List<Object> alternate_names = null;
private Object age_range;
private Object gender;
private String type;
private String link_to_phone_start_date;
private List<String> industry = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Object getFirstname() {
	return firstname;
}
public void setFirstname(Object firstname) {
	this.firstname = firstname;
}
public Object getMiddlename() {
	return middlename;
}
public void setMiddlename(Object middlename) {
	this.middlename = middlename;
}
public Object getLastname() {
	return lastname;
}
public void setLastname(Object lastname) {
	this.lastname = lastname;
}
public List<Object> getAlternate_names() {
	return alternate_names;
}
public void setAlternate_names(List<Object> alternate_names) {
	this.alternate_names = alternate_names;
}
public Object getAge_range() {
	return age_range;
}
public void setAge_range(Object age_range) {
	this.age_range = age_range;
}
public Object getGender() {
	return gender;
}
public void setGender(Object gender) {
	this.gender = gender;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getLink_to_phone_start_date() {
	return link_to_phone_start_date;
}
public void setLink_to_phone_start_date(String link_to_phone_start_date) {
	this.link_to_phone_start_date = link_to_phone_start_date;
}
public List<String> getIndustry() {
	return industry;
}
public void setIndustry(List<String> industry) {
	this.industry = industry;
}
public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}
public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}


}