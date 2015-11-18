package fhw;

import java.lang.Enum; 

public enum NewFrogTypeEnum 
   
{    
    GREEN(1L,"Green Frog"), 
    BLUE(2L, "Blue Frog"), 
    PURPLE(3L, "Purple Frog"); 
    
    private Long id; 
    private String label; 
    
    NewFrogTypeEnum(Long typeId, String l)
    {
        id = typeId; 
        label = l; 
    }

    public Long getId() {
        return id;
    }

    public String getLabel() 
    {
        return label;
    }
    
    public static NewFrogTypeEnum find(String l)
    {
        NewFrogTypeEnum fte = null;
        for(NewFrogTypeEnum f : values())
        {
            if(f.getLabel().equals(l))
            {
                fte = f;
                break;
            }
        }
        return(fte);
        
    }

}
