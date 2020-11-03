/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.seminar2;

import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 *
 * @author Bogdan
 */
public class SimpleResponseWrapper
extends HttpServletResponseWrapper {
 private final StringWriter output;
 public SimpleResponseWrapper(HttpServletResponse response) {
 super(response);
 output = new StringWriter();
 }
 @Override
 public PrintWriter getWriter() {
 // Hide the original writer
 return new PrintWriter(output);
 }
 @Override
 public String toString() {
 return output.toString();
 }
}