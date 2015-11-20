
package fhw;

import java.util.Collection;
import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("outsideDomainEnumConverter")
public class OutsideDomainEnumConverter
        implements Converter 
{
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String enumLabel)
    {
        Map<String,Object> attrs = uic.getAttributes();
        Collection c  = (Collection)attrs.get("enums");        
        BaseEnum be = (BaseEnum)c.toArray()[0];
        Enum e = be.findByLabel(enumLabel);
        if(null == e)
        {
            String mtLabel = (String)attrs.get("emptyItemLabel"); 
            if(! mtLabel.equals(enumLabel))
            {
                String s = String.format("%s, is not a valid enumeration value nor is it the designated empty marker (%s) for this enumeration select", enumLabel, mtLabel); 
                throw new IllegalArgumentException(s); 
            }
        }
        return(e); 
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o)
    {
        return(null); 
    }
    
}
