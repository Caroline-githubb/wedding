package br.com.casamento.carolerodrigo.back.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class HttpsRedirect {

    private final static String SECURITY_USER_CONSTRAINT = "CONFIDENTIAL";
    private final static String REDIRECT_PATTERN = "/*";
    private final static String CONNECTOR_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
    private final static String CONNECTOR_SCHEME = "http";

    @Value("${http.port}")
    private int httpPort;

    @Value("${server.port}")
    private int httpsPort;

    @Value("${https.redirect.port:DEFAULT}")
    private Optional<Integer> httpsRedirectPort = Optional.empty();

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat =
                new TomcatServletWebServerFactory() {

                    @Override
                    protected void postProcessContext(Context context) {
                        SecurityConstraint securityConstraint = new SecurityConstraint();
                        securityConstraint.setUserConstraint(SECURITY_USER_CONSTRAINT);
                        SecurityCollection collection = new SecurityCollection();
                        collection.addPattern(REDIRECT_PATTERN);
                        securityConstraint.addCollection(collection);
                        context.addConstraint(securityConstraint);
                    }
                };
        tomcat.addAdditionalTomcatConnectors(createConnection());
        return tomcat;
    }

    private Connector createConnection() {
        final Connector connector = new Connector(CONNECTOR_PROTOCOL);

        int portRedirect = httpsRedirectPort.orElse(httpsPort);

        connector.setScheme(CONNECTOR_SCHEME);
        connector.setPort(httpPort);
        connector.setRedirectPort(portRedirect);
        return connector;
    }

}
