package fhw;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ValidationException;


public class FrogsNotAllowedConstraint
    implements ConstraintValidator<FrogsNotAllowed,Object> 
{
    private FrogTypeEnum[] blackList; 
    
    public FrogsNotAllowedConstraint() {} 
    
    @Override
    public void initialize(FrogsNotAllowed a)
    {
        blackList = new FrogTypeEnum[a.blackList().length];
        int ii = 0;
        for(String s : a.blackList())
        {
            blackList[ii] = FrogTypeEnum.find(s);
            ii++;
        }
    }

    @Override
    public boolean isValid(Object t, ConstraintValidatorContext cvc)
    {
        boolean b = true; 
        FrogTypeEnum fte = null; 
        Class clazz = t.getClass();
        if(t instanceof String)
        {
            fte = FrogTypeEnum.find((String)t); 
        }
        else if(t instanceof FrogTypeEnum )
        {
            fte = (FrogTypeEnum)t;
        }        
        else if(!(t instanceof NullBaseEnum))
        {
            throw new ValidationException("unsuported type: " + clazz.getName());
        }        
        if(null!= fte)
        {
            for(FrogTypeEnum f : blackList)
            {
                if(f.equals(fte))
                {
                    b = false;
                    break;
                }
            }
        }
        return(b);
    }

}