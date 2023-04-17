package com.exampleCt.demoCommercetools.Zone;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.zone.Zone;
import com.commercetools.api.models.zone.ZoneDraft;
import com.exampleCt.demoCommercetools.Client;

public class ZoneDataProvider {

    ProjectApiRoot apiRoot= new Client().createApiClient();

    public Zone createZone(ZoneDraft zoneDraft) {
        return apiRoot.zones().post(zoneDraft).executeBlocking().getBody();

    }
}
