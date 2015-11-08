package fhw;

import javax.enterprise.event.Observes;
import org.picketlink.config.SecurityConfigurationBuilder;
import org.picketlink.event.SecurityConfigurationEvent;

public class MySecurityObserver
{

    public MySecurityObserver() {}
    
    public void onInit(@Observes SecurityConfigurationEvent event)
    {
        SecurityConfigurationBuilder builder = event.getBuilder();

        builder
                .http()
                .forPath("/secure/*")
                .authenticateWith()
                .form()
                .loginPage("/index.xhtml")
                .errorPage("/error.xhtml")
                .restoreOriginalRequest()
                .forPath("/logout.xhtml")
                .logout()
                .redirectTo("/index.xhtml");
    }

}
