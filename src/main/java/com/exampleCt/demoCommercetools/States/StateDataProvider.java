package com.exampleCt.demoCommercetools.States;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.state.State;
import com.commercetools.api.models.state.StateDraft;
import com.exampleCt.demoCommercetools.Client;

public class StateDataProvider {

    ProjectApiRoot projectApiRoot= new Client().createApiClient();

    public State createState(StateDraft stateDraft) {
        return projectApiRoot.states().post(stateDraft).executeBlocking().getBody();
    }
}
