package com.gnaderi.superhero.inbound;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@ApiModel(value = "CreateSuperheroRequest", description = "Create Superhero Request resource representation")
@JsonIgnoreProperties(ignoreUnknown = false)
@JsonPropertyOrder(value = {"name", "pseudonym", "firstAppearance", "publisher", "skills", "allies",})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateSuperheroRequest implements Serializable {
    private static final long serialVersionUID = 6893422408140886331L;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pseudonym")
    private String pseudonym;
    @JsonProperty("firstAppearance")
    private Date firstAppearance;
    @JsonProperty("publisher")
    private Long publisher;

    @JsonProperty("skills")
    @ApiModelProperty(value = "A collection of the returned superhero skills and powers ID's", required = true, dataType = "List")
    private List<Long> superheroSkills;

    @JsonProperty("allies")
    @ApiModelProperty(value = "A collection of the returned superhero allies ID's", required = true, dataType = "List")
    private List<Long> superheroAllies;

    public CreateSuperheroRequest() {
    }

    public CreateSuperheroRequest(String name, String pseudonym, Date firstAppearance, Long publisher, List<Long> superheroSkills, List<Long> superheroAllies) {
        this.name = name;
        this.pseudonym = pseudonym;
        this.firstAppearance = firstAppearance;
        this.publisher = publisher;
        this.superheroSkills = superheroSkills;
        this.superheroAllies = superheroAllies;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Date getFirstAppearance() {
        return firstAppearance;
    }

    public void setFirstAppearance(Date firstAppearance) {
        this.firstAppearance = firstAppearance;
    }

    public Long getPublisher() {
        return publisher;
    }

    public void setPublisher(Long publisher) {
        this.publisher = publisher;
    }

    public List<Long> getSuperheroSkills() {
        return superheroSkills;
    }

    public void setSuperheroSkills(List<Long> superheroSkills) {
        this.superheroSkills = superheroSkills;
    }

    public List<Long> getSuperheroAllies() {
        return superheroAllies;
    }

    public void setSuperheroAllies(List<Long> superheroAllies) {
        this.superheroAllies = superheroAllies;
    }
}