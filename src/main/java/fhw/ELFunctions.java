package fhw;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

public class ELFunctions
{
    private ELFunctions() {}
    
    public Boolean inputFailsValidation(UIInput input)
    {
        Boolean b = Boolean.FALSE;
        if(!input.isValid())
        {
            b = Boolean.TRUE; 
        }
        return(b);
    }
    
    public Boolean inputFailedValidation(String inputId)
    {
        Boolean b = Boolean.FALSE;
        UIViewRoot root = FacesContext.getCurrentInstance().getViewRoot();
        UIComponent uic = root.findComponent(inputId);
        if(UIInput.class.isInstance(uic))
        {
            b = inputFailsValidation((UIInput)uic);
        }
        return(b);        
    }
    
}
