
package com.poe.ladder.backend.external.api.response;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "realm",
    "challenges"
})
public class Account {

    @JsonProperty("name")
    private String name;
    @JsonProperty("realm")
    private String realm;
    @JsonProperty("challenges")
    private Challenges challenges;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("realm")
    public String getRealm() {
        return realm;
    }

    @JsonProperty("realm")
    public void setRealm(String realm) {
        this.realm = realm;
    }

    @JsonProperty("challenges")
    public Challenges getChallenges() {
        return challenges;
    }

    @JsonProperty("challenges")
    public void setChallenges(Challenges challenges) {
        this.challenges = challenges;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

	@Override
	public String toString() {
		return "Account [name=" + name + ", realm=" + realm + ", challenges=" + challenges + ", additionalProperties="
				+ additionalProperties + "]";
	}
    
}
