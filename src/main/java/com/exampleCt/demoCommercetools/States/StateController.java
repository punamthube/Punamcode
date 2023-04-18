package com.exampleCt.demoCommercetools.States;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StatePagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/States")
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
    @PostMapping("/{id}")
    public State getStateById(@PathVariable String id){
        return projectApiRoot.states().withId(id).get().executeBlocking().getBody();
    }
    @GetMapping
    public StatePagedQueryResponse getAllStates()
    {
        return projectApiRoot.states().get().executeBlocking().getBody();
    }



}
