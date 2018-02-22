package com.gnaderi.superhero.controller;

import com.gnaderi.superhero.entity.Skill;
import com.gnaderi.superhero.entity.Superhero;
import com.gnaderi.superhero.inbound.CreateSuperheroRequest;
import com.gnaderi.superhero.outbound.Response;
import com.gnaderi.superhero.outbound.SuperheroDetails;
import com.gnaderi.superhero.service.SuperheroService;
import com.gnaderi.superhero.util.RequestValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "Superhero Service REST API Interface", tags = "Superhero Service REST API Interface", description = "Superhero Service REST API Interface")
@PropertySource(value = "classpath:application.properties")
@RestController
public class SuperheroServiceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SuperheroServiceController.class);

    @Autowired
    private SuperheroService service;

    @Autowired
    private RequestValidator requestValidator;

    @ApiOperation(value = "Pull a list of all superheroes stored in application.",
            notes = "Retrieve all superheroes details.",
            produces = MediaType.TEXT_PLAIN_VALUE, response = Response.class,
            responseContainer = "String", httpMethod = "GET")

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody
    Response fetchAllSuperheroes() {
        LOGGER.info("Incoming request for all records.");
        final List<Superhero> superheroes = service.findAll();
        final List<SuperheroDetails> superheroDetails = new ArrayList<>(superheroes.size());
        superheroes.forEach(sp -> superheroDetails.add(new SuperheroDetails(sp, service.findPowers(sp), service.findAllies(sp))));
        Response outbound = new Response(superheroDetails);
        LOGGER.info("Outbound databind response:{}", outbound);
        return outbound;

    }

    @ApiOperation(value = "Find a superhero stored in application by superhero Id.",
            notes = "Find a superhero stored in application by superhero Id.",
            produces = MediaType.TEXT_PLAIN_VALUE, response = SuperheroDetails.class,
            responseContainer = "String", httpMethod = "GET")
    @RequestMapping(value = "/get/{heroId}", method = RequestMethod.GET)
    public @ResponseBody
    SuperheroDetails findById(@PathVariable Long heroId) throws Exception {
        LOGGER.info("Incoming request for superhero#{} details.", heroId);
        final Superhero superhero = service.findById(heroId);
        return getSuperheroDetails(superhero);

    }

    @ApiOperation(value = "Find a superhero stored in application by Name.",
            notes = "Find a superhero stored in application by superhero name.",
            produces = MediaType.TEXT_PLAIN_VALUE, response = SuperheroDetails.class,
            responseContainer = "String", httpMethod = "GET")
    @RequestMapping(value = "/search/{heroName}", method = RequestMethod.GET)
    public @ResponseBody
    SuperheroDetails findByName(@PathVariable String heroName) throws Exception {
        LOGGER.info("Incoming request for Superhero Name#{} details.", heroName);
        final Superhero superhero = service.findByName(heroName);
        return getSuperheroDetails(superhero);

    }

    private SuperheroDetails getSuperheroDetails(Superhero superhero) {
        SuperheroDetails outbound = new SuperheroDetails();
        if (superhero != null) {
            List<Skill> powers = service.findPowers(superhero);
            List<Superhero> allies = service.findAllies(superhero);
            outbound.setSuperhero(superhero);
            outbound.setSuperheroSkills(powers);
            outbound.setSuperheroAllies(allies);
        }
        LOGGER.info("Outbound databind response:{}", outbound);
        return outbound;
    }

    @ApiOperation(value = "Create a superhero and store it in application.",
            notes = "reate a superhero and store it with all details in application.",
            produces = MediaType.TEXT_PLAIN_VALUE, response = String.class,
            responseContainer = "String", httpMethod = "POST")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    String createSuperhero(@RequestBody CreateSuperheroRequest request) {
        LOGGER.info("Incoming request for create superhero info#{}.", request);
        requestValidator.validateRequest(request);
        boolean result = service.createSuperhero(request);
        LOGGER.info("Outbound databind response:{}", result);
        return result ? "OK. Created!" : "Unable to create the record.";
    }


}
