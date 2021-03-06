package music.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;

public class IfEmptyMarkTag extends TagSupport
{
    private String field;
    private String color = "red";

    public void setField(String field)
    {
        this.field = field;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int doStartTag() throws JspException
    {
        try
        {
            JspWriter out = pageContext.getOut();
            if (field == null || field.length() == 0)
            {
                out.print("<font color=" + color + "> *</font>");
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        return SKIP_BODY;
    }
}
