package com.exampleCt.demoCommercetools.States;

import com.commercetools.api.models.state.StateTypeEnum;
import lombok.Data;

@Data
public class StateData {

    public String key;

    public StateTypeEnum type;

    public String name;

    public String description;

    public Boolean initial;

   // public  String roles;
   // public  String transitions;
    public String id;

}
