package fhw;

public enum FrogTypeEnum 
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
}
