import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Category} from "../models/category";
import {Tables} from "../models/tables";

@Injectable()
export class WaiterService {
  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient,
                                                  @Inject('SOCKET_URL') private apiUrl) { }

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

  doPOSTonGettingTable(tableNumber:number){
    return this.http.post(this.apiUrl + 'getTable',tableNumber);
  }

  doPOSTonCloseCalling(tableNumber:number){
    return this.http.post(this.apiUrl + 'acceptCalling',tableNumber);
  }


}
