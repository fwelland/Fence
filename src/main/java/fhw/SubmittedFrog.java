package fhw;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import lombok.Data;
//import javax.validation.constraints.

@Named
@RequestScoped
@Data 
public class SubmittedFrog
{    
    private String color; 
    
    private Integer val; 
    
}
