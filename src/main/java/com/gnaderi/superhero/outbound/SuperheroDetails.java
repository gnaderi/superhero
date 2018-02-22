package com.gnaderi.superhero.outbound;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import com.gnaderi.superhero.entity.SuperheroAlliance;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "Response", description = "Response resource representation")
@JsonPropertyOrder(value = {"superhero","skills","allies"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperheroDetails implements Serializable {

    private static final long serialVersionUID = 6899822408140886331L;
    @JsonProperty("superhero")
    private Superhero superhero;

    @JsonProperty("skills")
    @ApiModelProperty(value = "A collection of the returned superhero skills and powers", required = true, dataType = "List")
    private List<Skill> superheroSkills;

    @JsonProperty("allies")
    @ApiModelProperty(value = "A collection of the returned superhero allies", required = true, dataType = "List")
    private List<Superhero> superheroAllies;

    public SuperheroDetails() {
    }

    public SuperheroDetails(Superhero superhero, List<Skill> superheroSkills, List<Superhero> superheroAllies) {
        this.superhero = superhero;
        this.superheroSkills = superheroSkills;
        this.superheroAllies = superheroAllies;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Superhero getSuperhero() {
        return superhero;
    }

    public void setSuperhero(Superhero superhero) {
        this.superhero = superhero;
    }

    public List<Skill> getSuperheroSkills() {
        return superheroSkills;
    }

    public void setSuperheroSkills(List<Skill> superheroSkills) {
        this.superheroSkills = superheroSkills;
    }

    public List<Superhero> getSuperheroAllies() {
        return superheroAllies;
    }

    public void setSuperheroAllies(List<Superhero> superheroAllies) {
        this.superheroAllies = superheroAllies;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}