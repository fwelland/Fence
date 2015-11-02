package fhw;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class Producer
{
    
    public Producer()
    { }

    @Produces
    @RequestScoped
    public FacesContext produceFacesContext()
    {
        return FacesContext.getCurrentInstance();
    }

}
