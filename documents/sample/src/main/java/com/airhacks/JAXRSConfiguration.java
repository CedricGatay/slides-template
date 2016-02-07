package com.airhacks;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Configures a JAX-RS endpoint. Delete this class, if you are not exposing
 * JAX-RS resources in your application.
 *
 * @author airhacks.com
 */
//tag::class[]
@ApplicationPath("resources")
public class JAXRSConfiguration extends Application {
}
//end::class[]
