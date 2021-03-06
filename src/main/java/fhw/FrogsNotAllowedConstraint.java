package fhw;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


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
        if(null != t)
        {
            FrogTypeEnum fte = null;         
            if(t instanceof FrogTypeEnum )
            {
                fte = (FrogTypeEnum)t;
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
        }
        return(b);
    }

}