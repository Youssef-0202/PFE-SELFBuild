import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {AdminComponent} from "./admin/admin.component";
import {UserComponent} from "./user/user.component";
import {LoginComponent} from "./login/login.component";
import {ForbiddenComponent} from "./forbidden/forbidden.component";
import {AuthGuard} from "./_auth/auth.guard";
import {MedecinComponent} from "./medecin/medecin.component";
import {InfermierComponent} from "./infermier/infermier.component";

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'home',component:HomeComponent},
  {path:'admin',component:AdminComponent ,canActivate:[AuthGuard],data:{roles:['Admin','medecin']}},
  {path:'user',component:UserComponent ,canActivate:[AuthGuard],data:{roles:['User']}},
  {path:'login',component:LoginComponent},
  {path:'medecin',component:MedecinComponent,canActivate:[AuthGuard],data:{roles:['medecin']}},
  {path:'infermier',component:InfermierComponent,canActivate:[AuthGuard],data:{roles:['infermier']}},
  {path:'forbidden',component:ForbiddenComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
