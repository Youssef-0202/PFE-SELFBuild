import { Component } from '@angular/core';
import {NgForm} from "@angular/forms";
import {UserService} from "../_services/user.service";
import { Observer } from 'rxjs';
import {UserAuthService} from "../_services/user-auth.service";
import {Router} from "@angular/router";
import {User} from "../_entity/User";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  private  user :User |undefined  ;
  constructor(
    private userService:UserService,
    private userAyhthService:UserAuthService,
    private router:Router
  ) {
  }

  login(loginForm :NgForm) {
    this.userService.login(loginForm.value).subscribe({
      next: (response:any) => {
        this.userService.setUser(response.user)
        this.userAyhthService.setRoles(response.user.role);
        this.userAyhthService.setTokent(response.jwtToken);
      const role = response.user.role[0].roleName;
      if(role==='Admin'){
         this.router.navigate(['/admin'])
      }else if(role==='medecin'){
        this.router.navigate(['/medecin'])
      }else if(role==='infermier'){
        this.router.navigate(['/infermier'])
      }
      else {
          this.router.navigate(['/user'])
        }
      },
      error: (err) => {
        console.log(err);
      }
    });
  }
}
