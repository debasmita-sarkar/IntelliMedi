package com.intellimedi.controller;

import com.intellimedi.entity.HealthParameters;
import com.intellimedi.exception.EmptyRequestException;
import com.intellimedi.exception.UserDoesNotExistException;
import com.intellimedi.service.HealthParameterService;
import com.intellimedi.utils.URLConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Set;

@RestController
@RequestMapping(URLConstants.HEALTH_PARAMS)
public class HealthParameterController {
    private static final Logger logger = LogManager.getLogger(HealthParameterController.class);

    @Autowired
    HealthParameterService service;

    @RequestMapping(method= RequestMethod.POST, value=com.intellimedi.utils.URLConstants.ADD)
    @CrossOrigin(origins = "*")
    public HealthParameters AddHealthParam(@RequestBody HealthParameters healthParam) throws EmptyRequestException {
        System.out.println("In HealthParameters controller:"+healthParam.getUser());
        logger.debug("In HealthParameters controller:{}",healthParam.getUser());
        HealthParameters addedHealthParam =  service.addHealthParam(healthParam);
        return addedHealthParam;
    }


    @RequestMapping(method=RequestMethod.DELETE, value="")
    public void deleteAddress(@RequestParam BigInteger id) {
        service.deleteById(id);
    }

    @RequestMapping(value="")
    @ResponseBody
    public HealthParameters getHealthParamValues(@RequestParam BigInteger id) {
        return service.getHealthParamById(id);
    }

    @RequestMapping(value=URLConstants.BYUSER)
    @ResponseBody
    public Set<HealthParameters> getHealthParamsByUser(@RequestParam BigInteger userId) throws UserDoesNotExistException {
        return service.getHealthParamsByUser(userId);
    }

    @RequestMapping(value=URLConstants.FOR_PERIOD)
    @ResponseBody
    public Set<HealthParameters> getHealthParamsByUserForAPeriod(@RequestParam BigInteger userId) throws UserDoesNotExistException {
        return service.getHealthParamsByUser(userId);
    }

    @RequestMapping(value=URLConstants.LATEST)
    @ResponseBody
    public HealthParameters getLatestHealthParamsForAUser(@RequestParam BigInteger userId) throws UserDoesNotExistException {
        return service.getLatestHealthParamsByUser(userId);
    }




}

