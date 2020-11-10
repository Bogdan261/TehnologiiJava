/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Bogdan
 */


@WebFilter(filterName = "RequestFilter", urlPatterns = {"/inputcontroller"} )
public class RequestFilter implements Filter {
 private FilterConfig filterConfig = null;
 private String language;
 @Override
 public void init(FilterConfig filterConfig)
         throws ServletException{
     this.filterConfig = filterConfig;
     language = filterConfig.getInitParameter("language");
 }
 @Override
 public void destroy()
 {
     this.filterConfig = null;
 }
 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
 throws IOException, ServletException {
 HttpServletRequest req = (HttpServletRequest) request;
 SimpleResponseWrapper respWrapper
     = new SimpleResponseWrapper((HttpServletResponse) response);

 ServletContext context = filterConfig.getServletContext();
 context.log(req.getMethod());


 if(req.getParameter("definition").equals("") || req.getParameter("word").equals("")) 
 { HttpServletResponse httpResponse = (HttpServletResponse) response;
   httpResponse.sendRedirect("input.jsp");
   return;
 }
 else{
  if(req.getParameter("language").equals(""))
  {
      ServletRequestWrapper wrapper = new HttpServletRequestWrapper(req) {
      @Override
      public String getParameter(String key) {
      String value = request.getParameter(key);
      if (key.equals("language")) {
         return language;
       }
       return value;
      }
   };
  chain.doFilter(wrapper, respWrapper);
  }
      
  else chain.doFilter(req, respWrapper);
 }

 String content = respWrapper.toString();
 
 Document doc = Jsoup.parse(content);
 Elements cells = doc.select("td");
 for (Element element: cells)
 {
     element.appendText(" Si am modificat textul");
 }
 
 PrintWriter out = response.getWriter();
 out.write(doc.toString());
 }


 
}

