package fhw;

import javax.enterprise.context.RequestScoped;
import org.picketlink.idm.model.basic.User;
import org.picketlink.authentication.BaseAuthenticator;
import org.picketlink.credential.DefaultLoginCredentials;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.picketlink.annotations.PicketLink;
import org.picketlink.authentication.Authenticator;

@PicketLink
@RequestScoped
public class MyAuthenticator
    extends BaseAuthenticator
{
    @Inject
    private DefaultLoginCredentials credentials;

    @Inject
    private FacesContext facesContext;

    @Override
    public void authenticate()
    {
        if ("jsmith".equals(credentials.getUserId())  && "abc123".equals(credentials.getPassword()))
        {
            setStatus(Authenticator.AuthenticationStatus.SUCCESS);
            setAccount(new User("jsmith"));  
        }
        else
        {
            setStatus(Authenticator.AuthenticationStatus.FAILURE);
            facesContext.addMessage(null, new FacesMessage("Authentication Failure - The username or password you provided were invalid."));
        }
    }
}
