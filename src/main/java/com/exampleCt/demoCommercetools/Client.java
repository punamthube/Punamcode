package com.exampleCt.demoCommercetools;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Client {
    @Bean
    public  ProjectApiRoot createApiClient() {
        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("1hxnBn7OrDEtSiHs8cXGp164")
                                .withClientSecret("AnvooCnqKLjmMiMfnwJw2Qyf5j0TNm1r")

                                .build(),
                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("project-new");

        return apiRoot;
    }


}
