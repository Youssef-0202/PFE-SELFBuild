import {
  ActivatedRouteSnapshot,
  CanActivate,
  CanActivateFn,
  Router,
  RouterStateSnapshot,
  UrlTree
} from '@angular/router';
import {Observable} from 'rxjs';
import {UserAuthService} from "../_services/user-auth.service";
import {UserService} from "../_services/user.service";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  constructor(
    private userAuthService: UserAuthService,
    private router: Router,
    private userService: UserService
  ) {}
    canActivate(
      route: ActivatedRouteSnapshot,
      state: RouterStateSnapshot):   any  {
         if(this.userAuthService.getToken()!== null){
          const role =  route.data["roles"] as Array<String>;
           if(role){
            // @ts-ignore
             const match = this.userService.roleMAtch(role);
               if(match){
                  return true;
               }else {
                this.router.navigate(['/forbidden']);
                return false;
            }

    }
   }
      this.router.navigate(['/login']);
    }
}


