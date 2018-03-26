import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../../services/auth.service";

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit {

  constructor(public authService:AuthService) { }

  ngOnInit() {
  }
  isAuthenticated():boolean {
    return this.authService.isAuthenticated();
  }
  logout(){
    this.authService.logout();
  }
}
