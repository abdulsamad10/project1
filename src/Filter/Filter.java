package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by bse173024 on 10/19/2020.
 */
@WebFilter(filterName = "Filter")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        PrintWriter out=resp.getWriter();
        String localhost="";
        String ip=req.getRemoteHost();
        if(ip.matches("0:0:0:0:0:0:0:1"))
        {

            out.write("127.0.0.1 is Blocked!");
        }
        else
        {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
