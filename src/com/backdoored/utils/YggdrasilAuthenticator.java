package com.backdoored.utils;

import net.minecraft.util.Session;

public class YggdrasilAuthenticator
{
    public YggdrasilPayload Payload;
    public String Username;
    public String Password;
    private Session session;
    
    public YggdrasilAuthenticator(final String Username, final String Password) {
        super();
        this.Payload = new YggdrasilPayload();
        this.Username = Username;
        this.Password = Password;
    }
    
    public boolean login() {
        if (this.Password == null || this.Password.equals("")) {
            final YggdrasilPayload payload = this.Payload;
            final Session AuthResponseCrack = YggdrasilPayload.loginCrack(this.Username);
            this.session = AuthResponseCrack;
            return true;
        }
        final YggdrasilPayload payload2 = this.Payload;
        final Session AuthResponse = YggdrasilPayload.loginPassword(this.Username, this.Password);
        if (AuthResponse != null) {
            this.session = AuthResponse;
            return true;
        }
        return false;
    }
    
    public Session getSession() {
        return this.session;
    }
}
