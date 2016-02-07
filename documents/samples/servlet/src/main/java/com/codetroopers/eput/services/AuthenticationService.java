package com.codetroopers.eput.services;


import com.codetroopers.eput.models.UserInfo;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ApplicationScoped
public class AuthenticationService implements Serializable {

//    @Inject
//    FacesContext facesContext;

    /**
     * Login method checking if the supplied userInfo matches our condition on its password/nickname combination :
     * <p>
     * As a side effect, it sets the flag userInfo#loggedIn with the result of the check
     *
     * @param userInfo userInfo to check
     * @return next view to show / null if a refresh is needed
     */
    public String login(final UserInfo userInfo) {
        if ("tpjava".equals(userInfo.getName()) && "secret".equals(userInfo.getPassword())) {
            userInfo.setLoggedIn(true);
            return "success";
        }
        FacesContext.getCurrentInstance().addMessage("Invalid credentials", new FacesMessage("Invalid credentials !"));
        return null;
    }

    /**
     * Method to invalidate current user session. It relies on invalidating user's session from FacesContext
     *
     * @return next path (with redirect)
     */
    public String logout() {
//        facesContext.getExternalContext().invalidateSession();
        return "login" + "?faces-redirect=true";
    }

    String login(final String nickName, final String password) {
        boolean validLogin = false;
        return null;
    }
}
