import { Component, OnInit } from '@angular/core';
import {AuthService} from "../services/auth.service";
import {headersToString} from "selenium-webdriver/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  password:string;
  email:string;

  constructor(public authSevice:AuthService, private router: Router) { }

  ngOnInit() {
  }
  login(){
    this.authSevice.logUserIn(this.email, this.password)
      .then((res:Response)=>{ console.log(res.headers.get("Authorization"));
      localStorage.setItem("token", res.headers.get("Authorization")); localStorage.setItem("username", this.email); this.router.navigateByUrl("/welcome")});
  }
}
