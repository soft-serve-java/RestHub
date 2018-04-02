import { Component, OnInit } from '@angular/core';
import {Status} from "../../models/status";
import {AdminOrderService} from "../../services/admin-order.service";
import {StaticticService} from "../../services/statictic.service";
import {forEach} from "@angular/router/src/utils/collection";

@Component({
  selector: 'app-admin-status',
  templateUrl: './admin-status.component.html',
  styleUrls: ['./admin-status.component.css']
})
export class AdminStatusComponent implements OnInit {
  public data:[Object];
  public barChartLabels:string[];

  constructor(public adminOrderService: AdminOrderService, public statisticService:StaticticService) { }

  ngOnInit() {
    this.adminOrderService.getStatuses().then(res => this.statuses = res);
    this.statisticService.getPopulars().then(res=>{this.data=res; console.log(res);
    this.barChartLabels = this.data.map(item=>item[1]);
    console.log(this.barChartLabels);
    this.barChartData=[{data: this.data.map(item=>item[0]), label: 'The most popular'}]});
  }
  public barChartType:string = 'bar';

  public barChartData:any[];
  public chartClicked(e:any):void {
    console.log(e);
  }

  public chartHovered(e:any):void {
    console.log(e);
  }
  public lineChartData:Array<any> = [
    {data: [65, 59, 80, 81, 56, 55, 40,  81, 56, 55, 40,  81], label: 'Average check'},
  ];
  public lineChartLabels:Array<any> = ['January', 'February', 'March', 'April', 'May', 'June', 'July', "August", "September", "October", "November", "December"];
  public lineChartOptions:any = {
    responsive: true
  };
  public lineChartColors:Array<any> = [
    { // grey
      backgroundColor: 'rgba(255,204,51,0.2)',
      borderColor: 'rgba(255,153,0,1)',
      pointBackgroundColor: 'rgba(148,159,177,1)',
      pointBorderColor: '#fff',
      pointHoverBackgroundColor: '#fff',
      pointHoverBorderColor: 'rgba(148,159,177,0.8)'
    }
  ];
  public lineChartLegend:boolean = true;
  public lineChartType:string = 'line';

  public randomize():void {
    let _lineChartData:Array<any> = new Array(this.lineChartData.length);
    for (let i = 0; i < this.lineChartData.length; i++) {
      _lineChartData[i] = {data: new Array(this.lineChartData[i].data.length), label: this.lineChartData[i].label};
      for (let j = 0; j < this.lineChartData[i].data.length; j++) {
        _lineChartData[i].data[j] = Math.floor((Math.random() * 100) + 1);
      }
    }
    this.lineChartData = _lineChartData;
  }

  statuses: Status[];
}
