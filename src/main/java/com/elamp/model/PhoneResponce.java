package com.elamp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneResponce {

private String id;
private String phone_number;
private Boolean is_valid;
private String country_calling_code;
private String line_type;
private String carrier;
private Boolean is_prepaid;
private Boolean is_commercial;
private List<BelongsTo> belongs_to = null;
private List<CurrentAddress> current_addresses = null;
private List<Object> historical_addresses = null;
private List<AssociatedPerson> associated_people = null;
private List<Object> alternate_phones = null;
private Object error;
private List<Object> warnings = null;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String phone_number) {
	this.phone_number = phone_number;
}
public Boolean getIs_valid() {
	return is_valid;
}
public void setIs_valid(Boolean is_valid) {
	this.is_valid = is_valid;
}
public String getCountry_calling_code() {
	return country_calling_code;
}
public void setCountry_calling_code(String country_calling_code) {
	this.country_calling_code = country_calling_code;
}
public String getLine_type() {
	return line_type;
}
public void setLine_type(String line_type) {
	this.line_type = line_type;
}
public String getCarrier() {
	return carrier;
}
public void setCarrier(String carrier) {
	this.carrier = carrier;
}
public Boolean getIs_prepaid() {
	return is_prepaid;
}
public void setIs_prepaid(Boolean is_prepaid) {
	this.is_prepaid = is_prepaid;
}
public Boolean getIs_commercial() {
	return is_commercial;
}
public void setIs_commercial(Boolean is_commercial) {
	this.is_commercial = is_commercial;
}
public List<BelongsTo> getBelongs_to() {
	return belongs_to;
}
public void setBelongs_to(List<BelongsTo> belongs_to) {
	this.belongs_to = belongs_to;
}
public List<CurrentAddress> getCurrent_addresses() {
	return current_addresses;
}
public void setCurrent_addresses(List<CurrentAddress> current_addresses) {
	this.current_addresses = current_addresses;
}
public List<Object> getHistorical_addresses() {
	return historical_addresses;
}
public void setHistorical_addresses(List<Object> historical_addresses) {
	this.historical_addresses = historical_addresses;
}
public List<AssociatedPerson> getAssociated_people() {
	return associated_people;
}
public void setAssociated_people(List<AssociatedPerson> associated_people) {
	this.associated_people = associated_people;
}
public List<Object> getAlternate_phones() {
	return alternate_phones;
}
public void setAlternate_phones(List<Object> alternate_phones) {
	this.alternate_phones = alternate_phones;
}
public Object getError() {
	return error;
}
public void setError(Object error) {
	this.error = error;
}
public List<Object> getWarnings() {
	return warnings;
}
public void setWarnings(List<Object> warnings) {
	this.warnings = warnings;
}
public Map<String, Object> getAdditionalProperties() {
	return additionalProperties;
}
public void setAdditionalProperties(Map<String, Object> additionalProperties) {
	this.additionalProperties = additionalProperties;
}


}

