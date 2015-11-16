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
        if(String.class.isInstance(t))
        {
            fte = FrogTypeEnum.find((String)t); 
        }
        else if(FrogTypeEnum.class.isInstance(t))
        {
            fte = (FrogTypeEnum)t;
        }
        else
        {
            throw new ValidationException("unsuported type: " + clazz.getName());
        }
        for(FrogTypeEnum f : blackList)
        {
            if(f.equals(fte))
            {
                b = false;
                break;
            }
        }
        return(b);
    }

}