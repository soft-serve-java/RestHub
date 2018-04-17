import { Component, OnInit } from '@angular/core';
import {AppService} from "../../../services/app.service";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  constructor(public appService: AppService) { }

  ngOnInit() {
  }

}
