/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.bootstrap.showcase;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.ArrayList;

@ParentPackage(value = "showcase")
public class Languages extends ActionSupport {

    private static final long serialVersionUID = -3066791113091431706L;
    private static String[] staticLanguages =
            {
                    "Actionscript (Flash)",
                    "ABAP Objects",
                    "Ada",
                    "Aleph",
                    "AppleScript",
                    "Beta",
                    "BlitzMax",
                    "Boo",
                    "C++",
                    "C#",
                    "Cecil",
                    "Clarion",
                    "Cobol ISO 2002",
                    "CoDeSys",
                    "CFML (ColdFusion Markup Language)",
                    "Common Lisp Object System (CLOS)",
                    "Component Pascal",
                    "CorbaScript",
                    "D",
                    "Delphi",
                    "Eiffel",
                    "Fpii",
                    "Fortran - ab Fortran 2003",
                    "Gambas",
                    "IDL",
                    "IDLscript",
                    "incr Tcl",
                    "Java",
                    "JavaScript / ECMAScript",
                    "Lexico",
                    "Lingo",
                    "Modula-3",
                    "Modelica",
                    "NewtonScript",
                    "Oberon",
                    "Objective-C",
                    "Objective CAML",
                    "Object Pascal",
                    "Perl",
                    "PHP",
                    "PowerBuilder",
                    "Progress OpenEdge",
                    "Python",
                    "Ruby",
                    "R",
                    "Sather",
                    "Scala",
                    "Seed7",
                    "Self",
                    "Simula",
                    "Smalltalk",
                    "SuperCollider",
                    "Superx++",
                    "STOOOP",
                    "Visual Basic",
                    "Visual Basic .NET (VB.NET)",
                    "Visual Basic Script",
                    "Visual Objects",
                    "XBase",
                    "XOTcl",
                    "Zonnon"
            };

    private String term;
    private String[] languages = com.jgeppert.struts2.bootstrap.showcase.Languages.staticLanguages;

    @Action(value = "/languages", results = {
            @Result(type = "json", name = "success", params = {
                    "root", "languages"
            })})
    public String execute() throws Exception {
        if (term != null && term.length() > 1) {
            ArrayList<String> tmp = new ArrayList<String>();
            for (String staticLanguage : staticLanguages) {
                if (StringUtils.contains(staticLanguage.toLowerCase(), term.toLowerCase())) {
                    tmp.add(staticLanguage);
                }
            }
            languages = tmp.toArray(new String[tmp.size()]);
        }
        return SUCCESS;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
