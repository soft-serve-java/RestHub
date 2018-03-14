import {Inject, Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Category} from "../models/category";
import {Tables} from "../models/tables";

@Injectable()
export class WaiterService {
  constructor(@Inject('API_URL') private categoryApi: string, private http:HttpClient) { }
  getTablesWhithStatus(): Observable<Array<Tables>>{
    return this.http.get<Array<Tables>>(this.categoryApi + 'tableStatus')
  }

}
