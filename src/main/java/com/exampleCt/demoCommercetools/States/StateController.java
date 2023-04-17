package com.exampleCt.demoCommercetools.States;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.state.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Sates")
public class StateController {

    @Autowired
    StateService stateService;

    @Autowired
    ProjectApiRoot projectApiRoot;


    @PostMapping
    public State createState(@RequestBody StateData stateData)
    {
        return stateService.createState(stateData);

    }
}
