package fhw;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
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
        //facesContext.getExternalContext().getSessionMap()
        System.out.println("getting color " + color);
        return(color);
    }

    public void setColor(String c)
    {
        System.out.println("setting color with " + c );
        color = c;
    }
}
