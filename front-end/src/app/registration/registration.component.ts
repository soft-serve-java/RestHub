import { Component, OnInit } from '@angular/core';
import {User} from "../models/user";
import {AuthService} from "../services/auth.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  password:string;
  passwordConfirm:string;
  email:string;
  login:string;
  error:boolean;
  massage:string;
  constructor(public authservice:AuthService){ }

  ngOnInit() {
  }
  registration(){
    if(this.password!=this.passwordConfirm){
      this.massage = "Passwords doesn't match";
      this.error = true;
      return;
    }
    let user:User = new User(this.login, this.email, this.password);
    this.authservice.register(user);
    //TODO:confirmation after!!!!!!!!!!!!(Router to conf + in back-end)
  }

}
