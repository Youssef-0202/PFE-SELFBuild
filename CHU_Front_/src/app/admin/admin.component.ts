import {Component, OnInit} from '@angular/core';
import {UserService} from "../_services/user.service";
import {Medecin} from "../_models/Medecin";
import {MedcinService} from "../_services/medcin.service";

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit{
  public message : string|undefined ;
  constructor(private  userService:UserService, private medecinService:MedcinService) {
  }

  ngOnInit(): void {

  }


  onAddMedecin() {
  this.medecinService.save().subscribe(
    res =>{
       this.message = res;
    }
  )
  }
}
