package com.gnaderi.superhero.util;


import com.gnaderi.superhero.SuperheroException;
import com.gnaderi.superhero.inbound.CreateSuperheroRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public final class RequestValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestValidator.class);

    @Autowired
    private Environment env;

    public void validateRequest(final CreateSuperheroRequest request) throws SuperheroException {
        try {
          //TODO
        } catch (NullPointerException | IllegalArgumentException ex) {
            LOGGER.error("Invalid Request:", ex);
            throw new SuperheroException("Invalid request!");
        }

    }

}