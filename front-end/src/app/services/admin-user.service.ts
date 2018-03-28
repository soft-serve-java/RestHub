import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Category} from "../models/category";
import {Observable} from "rxjs/Observable";
import {User} from "../models/user";

@Injectable()
export class AdminUserService {

  constructor(@Inject('API_URL') private userApi: string, private http:HttpClient) { }

  getUsers(): Promise<User[]>{
    return this.http.get<User[]>(this.userApi + "admin/user/all")
      .toPromise();
  }

  deleteUser(id: number): Promise<any>{
    return this.http
      .delete(this.userApi + "admin/user/" + id )
      .toPromise()
  }

  editUser(user: User): Promise<any>{
    return this.http
      .post(this.userApi + "admin/user/add/", user)
      .toPromise()
  }

  getUserById(id: number): Promise<User>{
    return this.http
      .get<User>(this.userApi + "admin/user/" + id)
      .toPromise()
  }
}
