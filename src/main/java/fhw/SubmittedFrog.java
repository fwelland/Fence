package fhw;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.StateManager;
import javax.faces.component.UIViewParameter;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewMetadata;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Data;
import javax.validation.constraints.Max;

@Named
@RequestScoped
@Data
public class SubmittedFrog
{
    private String color;

    @Max(50)
    private Integer val;


    @Inject
    private FacesContext facesContext;

    public String getColor()
    {
        System.out.println("getting color " + color);
        return(color);
    }

    public void setColor(String c)
    {
        System.out.println("setting color with " + c );
        color = c;
    }
    
    
    public Set<Map.Entry<String,Object>> getSessionSet()
    {
        return(facesContext.getExternalContext().getSessionMap().entrySet());
    }
    
    public void setSessionSet(Set<Map.Entry<String,Object>> s)
    {
        
    }    
    
    public String getVState()
    {
        
        StateManager sm = facesContext.getApplication().getStateManager();
        return( sm.getViewState(facesContext)); 
        
    }
    
    public void setVState(String s)
    {
    
    }
    
    public Collection<UIViewParameter> getViewParameters()
    {
        return(ViewMetadata.getViewParameters(facesContext.getViewRoot()));     
    }
    
    public void setViewParameter(Collection<UIViewParameter> uv)
    {
        
    }
}
