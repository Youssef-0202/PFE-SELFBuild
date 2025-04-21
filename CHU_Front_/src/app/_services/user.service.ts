import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {NgForm} from "@angular/forms";
import {UserAuthService} from "./user-auth.service";
import {User} from "../_entity/User";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  PATH_OF_API="http://localhost:8036"
  private user :User |undefined  ;
  public setUser(user:User){
    this.user=user ;
  }

  public getUser(){
    return this.user;
  }

  requestHeader= new HttpHeaders(
    { "No-Auth":"True"}
  )
  constructor(private httpClient:HttpClient,private userAuthService:UserAuthService) { }
  public login(logindata:NgForm){
    return this.httpClient.post(this.PATH_OF_API+ "/authenticate",logindata,{headers:this.requestHeader})
  }

  public forUser(){
    return this.httpClient.get(this.PATH_OF_API+ '/forUser',{
      responseType:'text'
    })
  }

  public forAdmin(){
    return this.httpClient.get(this.PATH_OF_API+"/forAdmin",{
      responseType:'text'
    })
  }

  public roleMAtch( allowedRoles :string[]): boolean{
    let isMatch :boolean = false;
    const userRoles = this.userAuthService.getRoles();
    if (userRoles!=null && userRoles){
      for(let i=0 ;i<userRoles.length ;i++){
        for (let j =0;j<allowedRoles.length;j++){
          if (userRoles[i].roleName === allowedRoles[j]){
            isMatch=true;
            return isMatch;
          }
        }
      }
    }
    return isMatch;
  }
}
