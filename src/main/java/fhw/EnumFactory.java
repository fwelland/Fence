package fhw;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EnumFactory
{
    public EnumFactory() {}
    
    
    public FrogTypeEnum[] getFrogTypes() 
    {
        return (FrogTypeEnum.values()); 
    }
    
}
