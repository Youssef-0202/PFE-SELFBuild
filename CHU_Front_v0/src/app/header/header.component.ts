import { Component } from '@angular/core';
import {UserAuthService} from "../_services/user-auth.service";
import {Router} from "@angular/router";
import {UserService} from "../_services/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  constructor(
    private userAuthService:UserAuthService,
    private router:Router,
    protected userService:UserService
  ) {
  }

  public isLoggeedIn(){
    return this.userAuthService.isLoggdIn()
  }

  onLogout() {
    this.userAuthService.cleare();
    this.router.navigate(["/home"])
  }
}
