import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Tables} from "../models/tables";
import {User} from "../models/user";

@Injectable()
export class WaiterService {
  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient,
              @Inject('API_URL') private apiUrl) { }

  getTablesWhithStatus(): Promise<Array<Tables>>{
    return this.http.get<Array<Tables>>(this.categoryApi + 'tableStatus').toPromise();
  }
  getTablesCount(): Promise<number>{
    return this.http.get<number>(this.categoryApi + 'tableQuantity').toPromise();
  }
  tableHasStatus(table: number, status:string,tables:Array<Tables>):boolean {
    let tab:Tables;
    for(let i=0; i<tables.length; i++) {
      tab = tables[i];
      return tab.currentTable == table && (tab.tableStatus == status);
    }
  }

  doPOSTonGettingTable(tableNumber:number):Promise<User>{
    return this.http.post<User>(this.apiUrl + 'getTable/'+tableNumber, localStorage.getItem("username")).toPromise();
  }

  doPOSTonCloseCalling(tableNumber:number):Promise<any>{
    return this.http.post(this.apiUrl + 'acceptCalling/'+tableNumber, localStorage.getItem("username")).toPromise();
  }
  doPOSTonCallWaiter(tableNumber:number):Promise<any> {
    return this.http.post<any>(this.apiUrl+ 'callWaiterClient', tableNumber).toPromise();

  }

}
