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
        System.out.println("EnumValueNotAllowedConstraint:initialize(): nothing important to do here.");
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
        System.out.println("t is of type " + clazz.getName());
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
            System.out.println("ho no my short are purple");
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
        System.out.println("EnumValueNotAllowedConstraint:isValid(): returnging " + b);
        return(b);
    }

}