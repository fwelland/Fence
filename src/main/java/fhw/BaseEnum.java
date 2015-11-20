package fhw;

public interface BaseEnum<T extends Enum>
{
    public String getLabel(); 
    public T findByLabel(String l);
}
