package com.gnaderi.superhero.outbound;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

@ApiModel(value = "Response", description = "Response resource representation")
@JsonPropertyOrder(value = {"superheroes"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {

    private static final long serialVersionUID = 6899822408140886331L;
    @JsonProperty("superheroes")
    @ApiModelProperty(value = "A collection of the returned superheroes details", required = true, dataType = "List")
    private List<SuperheroDetails> superheroes;

    public Response() {
    }

    public Response(List<SuperheroDetails> superheroes) {
        this.superheroes = superheroes;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public List<SuperheroDetails> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(List<SuperheroDetails> superheroes) {
        this.superheroes = superheroes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}