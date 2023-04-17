package com.exampleCt.demoCommercetools.Zone;



import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.zone.Zone;
import com.commercetools.api.models.zone.ZonePagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Zone")
public class ZoneController {



    @Autowired
    ZoneService zoneService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
    public  Zone createZone(@RequestBody ZoneDto zoneDto)
    {
        return  zoneService.createZone(zoneDto);
    }

    @GetMapping
    public ZonePagedQueryResponse getAllZones()
    {
        return projectApiRoot.zones().get().executeBlocking().getBody();
    }

    @GetMapping("/{id}")
    public Zone getZoneById(@PathVariable String id)
    {
        return projectApiRoot.zones().withId(id).get().executeBlocking().getBody();
    }


}
