import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor() { }
  public setRoles(roles:[]){
    localStorage.setItem("roles",JSON.stringify(roles))
  }
  public getRoles() {
    const rolesString = localStorage.getItem("roles");
    if (rolesString !== null) {
      return JSON.parse(rolesString);
    }
    return null; // or return any other default value you prefer
  }

  public setTokent(jwtToken:string){
    localStorage.setItem('jwtToken',jwtToken)
  }
  public getToken() {
    return localStorage.getItem("jwtToken");
  }
  public cleare(){
    localStorage.clear()
  }
  public isLoggdIn(){
    return this.getRoles() && this.getToken()
  }

}
