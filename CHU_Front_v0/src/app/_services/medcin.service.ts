import { Injectable } from '@angular/core';
import {Medecin} from "../_models/Medecin";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MedcinService {
 private _medecin !: Medecin ;
  PATH_OF_API="http://localhost:9090"
  constructor(private httpClient:HttpClient ) { }
 public save()  {
   return this.httpClient.get  (this.PATH_OF_API+ '/forMedecin',{
     responseType:'text'
   });
 }


  get medecin(): Medecin {
    return this._medecin;
  }

  set medecin(value: Medecin) {
    this._medecin = value;
  }
}
