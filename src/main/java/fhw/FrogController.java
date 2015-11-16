package fhw;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
@Data
public class FrogController 
{
    private String name; 
    private FrogTypeEnum type; 
    private FrogTypeEnum type2;     
    
    @FrogsNotAllowed(blackList = {"Blue Frog"}, message = "blue frogs are not allowed")
    private FrogTypeEnum type3; 

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Frog frog; 
    
    public FrogController() {}
    
    public void submit()
    {
        frog = new Frog(); 
        frog.setName(name);
        frog.setType(type);
        
        System.out.println("what is frog type 2?  " + type2); 
    }    
}
