package com.elamp.model;

import java.util.HashMap;
import java.util.Map;

public class AssociatedPerson {

private String id;
private String name;
private String firstname;
private String middlename;
private String lastname;
private String relation;
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

public String getFirstname() {
return firstname;
}

public void setFirstname(String firstname) {
this.firstname = firstname;
}

public String getMiddlename() {
return middlename;
}

public void setMiddlename(String middlename) {
this.middlename = middlename;
}

public String getLastname() {
return lastname;
}

public void setLastname(String lastname) {
this.lastname = lastname;
}

public String getRelation() {
return relation;
}

public void setRelation(String relation) {
this.relation = relation;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
