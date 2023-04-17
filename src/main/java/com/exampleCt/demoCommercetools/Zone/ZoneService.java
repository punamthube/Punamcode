package com.exampleCt.demoCommercetools.Zone;

import com.commercetools.api.models.zone.Location;
import com.commercetools.api.models.zone.Zone;
import com.commercetools.api.models.zone.ZoneDraft;
import org.springframework.stereotype.Service;

@Service
public class
ZoneService {

    ZoneDataProvider ZDP = new ZoneDataProvider();

    public Zone createZone(ZoneDto zoneDto) {
        ZoneDraft zoneDraft = ZoneDraft
                .builder()
                .key(zoneDto.getKey())
                .name(zoneDto.getName())
                .description(zoneDto.getDescription())
                .locations(Location.builder().country(zoneDto.getCountry()).state(zoneDto.getState()).build())
                .build();
        return ZDP.createZone(zoneDraft);
    }
}
