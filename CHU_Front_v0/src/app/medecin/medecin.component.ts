import {Component, OnInit} from '@angular/core';
import {UserService} from "../_services/user.service";
import {User} from "../_entity/User";

@Component({
  selector: 'app-medecin',
  templateUrl: './medecin.component.html',
  styleUrls: ['./medecin.component.css']
})
export class MedecinComponent implements OnInit{
  user: User | undefined;
  constructor(private userService :UserService) {
  }


  ngOnInit(): void {
    this.user=this.userService.getUser();
    }

    showDetails() {
       console.log(this.user)
      console.log(this.user)
   }
}


