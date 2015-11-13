package fhw;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FrogController 
{
    private String name; 
    private FrogTypeEnum type; 
    private FrogTypeEnum type2; 
    
    private Frog frog; 
    
    public FrogController() {}

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public FrogTypeEnum getType()
    {
        return type;
    }

    public void setType(FrogTypeEnum type)
    {
        this.type = type;
    }
    
    
    public void submit()
    {
        frog = new Frog(); 
        frog.setName(name);
        frog.setType(type);
        
        System.out.println("what is frog type 2?  " + type2); 
    }

    public FrogTypeEnum getType2()
    {
        return type2;
    }

    public void setType2(FrogTypeEnum type2)
    {
        this.type2 = type2;
    }
    
}
