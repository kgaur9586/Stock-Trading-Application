package com.neu.edu.stocktrading.model;

<<<<<<< HEAD
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;

=======
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

>>>>>>> bfa3d0c092865e6b8aacd1af30606a372ba3957f
@Component
public class LoginForm
{
    public LoginForm(){
        
    }
    @NotEmpty
    private String email ;

    @NotEmpty
    private String password;



    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public String toString() {
        return "{" +
            ", email='" + getEmail() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    
    


}