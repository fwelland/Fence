package fhw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.faces.component.FacesComponent;
import javax.faces.component.UINamingContainer;

@FacesComponent("selectOneDropDown")
public class SelectOneDropDownBackingComponent
    extends UINamingContainer
{
    public SelectOneDropDownBackingComponent() {}
        
    public BaseEnum[] getEnumerations()
    {        
        BaseEnum newVals[]; 
        Map<String,Object> attrs = getAttributes();
        Boolean incEmpty = (Boolean)attrs.get("includeEmpty");        
        Collection c  = (Collection)attrs.get("enums");
        String mtLabel = (String)attrs.get("emptyItemLabel");
        ArrayList<BaseEnum> al = new ArrayList<>();
        if(incEmpty)
        {
            NullBaseEnum b = new NullBaseEnum();
            b.setLabel(mtLabel);
            newVals = new BaseEnum[c.size() + 1];
            al.add(b);        
        }
        else
        {
            newVals = new BaseEnum[c.size()];
        }
        al.addAll(c);
        al.toArray(newVals);            
        return(newVals); 
    }    
}
    