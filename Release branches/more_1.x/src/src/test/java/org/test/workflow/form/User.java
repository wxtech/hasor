/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.test.workflow.form;
import org.more.util.attribute.IAttribute;
import org.more.workflow.form.FormBean;
import org.more.workflow.state.StateCache;
public class User implements FormBean, StateCache {
    private String account  = "account";
    private String password = "password";
    private Role   role     = new Role();
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void recoverState(IAttribute states) {
        this.account = (String) states.getAttribute("account");
    }
    public void saveState(IAttribute states) {
        states.setAttribute("account", account);
    }
};