
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
    "level",
    "class",
    "id",
    "experience",
    "depth"
})
public class Character {

    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private Double level;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("id")
    private String id;
    @JsonProperty("experience")
    private Double experience;
    @JsonProperty("depth")
    private Depth depth;
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

    @JsonProperty("level")
    public Double getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Double level) {
        this.level = level;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("experience")
    public Double getExperience() {
        return experience;
    }

    @JsonProperty("experience")
    public void setExperience(Double experience) {
        this.experience = experience;
    }

    @JsonProperty("depth")
    public Depth getDepth() {
        return depth;
    }

    @JsonProperty("depth")
    public void setDepth(Depth depth) {
        this.depth = depth;
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
		return "Character [name=" + name + ", level=" + level + ", _class=" + _class + ", id=" + id + ", experience="
				+ experience + ", depth=" + depth + ", additionalProperties=" + additionalProperties + "]";
	}

}
