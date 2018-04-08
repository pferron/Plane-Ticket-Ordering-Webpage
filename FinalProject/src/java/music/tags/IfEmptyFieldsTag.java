package music.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import static javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class IfEmptyFieldsTag extends TagSupport
{
    private String code;
    private String description;
    private String price;
    
    public void setCode(String code)
    {
        this.code = code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setPrice(String price)
    {
        this.price = price;
    }
    
    public int doStartTag() throws JspException
    {
        if ((code == null || code.length() == 0) && (description == null || description.length() == 0) &&(price == null || price.length() == 0))
        {
            return EVAL_BODY_INCLUDE;
        }
        else
        {
            return SKIP_BODY;
        }
    }
}
