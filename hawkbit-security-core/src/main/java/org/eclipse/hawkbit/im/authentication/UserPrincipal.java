/**
 * Copyright (c) 2015 Bosch Software Innovations GmbH and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.hawkbit.im.authentication;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * A software provisioning user principal definition stored in the
 * {@link SecurityContext} which contains the user specific attributes.
 * 
 *
 *
 *
 */
public class UserPrincipal implements UserDetails, Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1L;

    private final String username;
    private final String firstname;
    private final String lastname;
    private final String loginname;
    private final String tenant;
    private final String email;

    /**
     * @param username
     *            the user name of the user
     * @param firstname
     *            the first name of the user
     * @param lastname
     *            the last name of the user
     * @param loginname
     *            the login name of user
     * @param tenant
     *            the tenant of the user
     * @param email
     *            address of the user
     */
    public UserPrincipal(final String username, final String firstname, final String lastname, final String loginname,
            final String tenant, final String email) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.loginname = loginname;
        this.tenant = tenant;
        this.email = email;
    }

    /**
     * @return the username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @return the loginname
     */
    public String getLoginname() {
        return loginname;
    }

    /**
     * @return the tenant
     */
    public String getTenant() {
        return tenant;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public Collection<SimpleGrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
