import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {JwtHelperService} from "@auth0/angular-jwt";
import {Router} from "@angular/router";
import {User} from "../models/user";

@Injectable()
export class AuthService {
  public jwtHelper: JwtHelperService = new JwtHelperService();
  constructor(private http:HttpClient, public router:Router, @Inject('LOGIN_URL') private api: string) { }

  logUserIn(username:string, password:string):Promise<any>{
    return this.http.post(this.api+"login", {username:username, password:password},
      {observe:'response' }).toPromise();
  }
  public isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    return !this.jwtHelper.isTokenExpired(token);
  }
  logout() {
      localStorage.removeItem("token");
  }
  register(user:User):Promise<User>{
    return this.http.post<User>(this.api + "api/registration", user).toPromise();
  }

  confermToken(token: string) {
    return this.http.post(this.api + "api/confirm?token="+token,{}).toPromise();

  }
}
