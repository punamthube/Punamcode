package com.exampleCt.demoCommercetools.States;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StateDraft;
import com.commercetools.api.models.state.StateResourceIdentifier;
import org.springframework.stereotype.Service;

@Service
public class StateService {


    StateDataProvider StateDP = new StateDataProvider();

    public State createState(StateData stateData) {

        StateDraft stateDraft = StateDraft
                .builder()
                .key(stateData.getKey())
                .name(LocalizedString.ofEnglish(stateData.getName()))
                .description(LocalizedString.ofEnglish(stateData.getDescription()))
                .initial(stateData.getInitial())
                .type(stateData.getType())
                .transitions(StateResourceIdentifier.builder().id(stateData.getId()).build())
             //   .roles(stateData.getRoles())                     *******(Roles are only use for reviews) ***product return
                .build();
        return  StateDP.createState(stateDraft);
    }
}
