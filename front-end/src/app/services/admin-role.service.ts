import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Role} from "../models/role";

@Injectable()
export class AdminRoleService {

  constructor(@Inject('API_URL') private roleApi: string, private http:HttpClient){}

  getRole(): Promise<Role[]>{
    return this.http.get<Role[]>(this.roleApi + "admin/role/all").toPromise();
  }
}
