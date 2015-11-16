package fhw;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import org.omnifaces.util.Callback.WithArgument;
import org.omnifaces.util.Components;
import static org.omnifaces.util.Components.forEachComponent;


public class ELFunctions
{
    private ELFunctions() {}
    
    public static Boolean inputFailedValidation(final String inputId)
    {
        final boolean[] b = new boolean[1];   
        b[0] = true;
        forEachComponent()
            .ofTypes(UIInput.class)
            .invoke(new WithArgument<UIComponent>() 
            { 
                @Override public void invoke(UIComponent component) 
                {
                    String id = component.getId();
                    System.out.println("id is:  " + id);
                    if(id.endsWith(inputId))
                    {                        
                        UIInput in = (UIInput)component;
                        b[0] = in.isValid();
                    }
                }
            });        
        return b[0];
    }
    
}
