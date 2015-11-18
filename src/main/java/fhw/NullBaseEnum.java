package fhw;

public class NullBaseEnum
        implements BaseEnum
{
    private String label; 
    
    public NullBaseEnum() {}
    
    public void setLabel(String l)
    {
        label = l;
    }

    @Override
    public String getLabel()
    {
        return(label);
    }
    
}
