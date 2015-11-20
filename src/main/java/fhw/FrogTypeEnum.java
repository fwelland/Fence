package fhw;

public enum FrogTypeEnum 
    implements BaseEnum
{    
    GREEN(1L,"Green Frog"), 
    BLUE(2L, "Blue Frog"), 
    PURPLE(3L, "Purple Frog"); 
    
    private Long id; 
    private String label; 
    
    FrogTypeEnum(Long typeId, String l)
    {
        id = typeId; 
        label = l; 
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getLabel() 
    {
        return label;
    }
    
    @Override 
    public FrogTypeEnum findByLabel(String l)
    {
        return(find(l));
    }
    
    public static FrogTypeEnum find(String l)
    {
        FrogTypeEnum fte = null;
        for(FrogTypeEnum f : values())
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
